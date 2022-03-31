package com.luoji.rnhello.retrofit

import android.content.Context
import com.google.gson.Gson
import com.luoji.httpsdata.ResponseBean
import com.luoji.rnhello.BuildConfig
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext

/**
 * Author:Ace
 * Date:On 2022/1/12
 */
public class RetrofitBuilder private constructor() {

    companion object {
        fun getInstance(): RetrofitBuilder {
            return RetrofitBuilderHelper.instance
        }
    }

    private object RetrofitBuilderHelper {
        val instance = RetrofitBuilder();
    }

    private val MAX_TIME = 30L
    private val sDispatcher = Dispatcher()
    private val sConnectionPool = ConnectionPool()

    inline fun <reified T> createApi(context: Context): T {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(getRetrofitClient(context))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(T::class.java)
    }

    fun <T> getRequestBody(body: T): RequestBody {
        return Gson().toJson(body).toRequestBody("application/json;charset=utf-8".toMediaType())
    }

    fun getRetrofitClient(context: Context): OkHttpClient {
        val builder = OkHttpClient().newBuilder()

        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY

        builder.addInterceptor(logger)
        builder.addInterceptor(CommonRequestHeaderInterceptor(context))

        return builder.connectTimeout(MAX_TIME, TimeUnit.SECONDS)
            .readTimeout(MAX_TIME, TimeUnit.SECONDS)
            .writeTimeout(MAX_TIME, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .dispatcher(sDispatcher)
            .connectionPool(sConnectionPool)
            .build()
    }

    private fun <T> httpGo(
        request: suspend () -> ResponseBean<T>?
    ): Flow<ResponseBean<T>> = flow {
        runCatching {
            request()
        }.onSuccess {
            if (it == null) {
                emit(ResponseBean(code = RequestCode.NET_ERROR, msg = "请求失败"))
            } else {
                emit(it)
            }
        }.onFailure {
            //另外，try catch suspend 函数的时候需要注意重新抛出 CancellationException，否则可能导致协程块无法及时取消。 详细可以查看
            //https://blog.yujinyan.me/posts/jcip-notes-interruption-cancellation/#comparison-with-kotlin-coroutines
            if (it is CancellationException) {
                throw it
            } else {
                emit(ResponseBean(code = RequestCode.NET_ERROR, msg = it.message!!))
            }
        }
    }

    /**
     * 开始请求网络数据默认回调主线程
     */
    fun <T> start(
        callback: HttpRequestCallback<T>.() -> Unit,
        request: suspend () -> ResponseBean<T>?,
    ) = CoroutineScope(Dispatchers.IO).launch {
        httpGo { request() }.collect {
            responseLogic(Dispatchers.Main, callback, it);
        }
    }

    /**
     * 开始请求网络数据默 传递回调线程
     */
    fun <T> start(
        observerContext: CoroutineContext = Dispatchers.Main,
        callback: HttpRequestCallback<T>.() -> Unit,
        request: suspend () -> ResponseBean<T>?,
    ) = CoroutineScope(Dispatchers.IO).launch {
        httpGo { request() }.collect {
            responseLogic(observerContext, callback, it);
        }
    }

    /**
     * 处理请求之后的数据
     */
    private fun <T> responseLogic(
        observerContext: CoroutineContext = Dispatchers.Main,
        callback: HttpRequestCallback<T>.() -> Unit,
        value: ResponseBean<T>
    ) {
        CoroutineScope(observerContext).launch {
            val requestCallback = HttpRequestCallback<T>().apply(callback)
            when (value.code) {
                RequestCode.SUCCESS -> {
                    requestCallback.successCallback?.invoke(value.data!!)
                }
                RequestCode.FORCE_LOGOUT -> {
                    //强制退出等
//                    requestCallback.forceLogoutCallback?.invoke()
                }
                else -> {
                    requestCallback.failureCallback?.invoke(value.msg, value.code)
                }
            }
        }
    }
}
