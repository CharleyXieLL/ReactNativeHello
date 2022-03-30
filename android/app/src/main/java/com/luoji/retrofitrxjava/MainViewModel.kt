package com.luoji.retrofitrxjava

import android.util.Log
import androidx.lifecycle.liveData
import com.luoji.retrofitrxjava.base.BaseViewModel
import com.luoji.retrofitrxjava.bean.SendVerifyPostBean
import com.luoji.retrofitrxjava.bean.SendVerifyResponseBean
import com.luoji.retrofitrxjava.retrofit.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import okhttp3.internal.wait
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

/**
 * Author:Ace
 * Date:On 2022/1/5
 */
class MainViewModel : BaseViewModel<MainApiService>() {

    fun sendVerify(sendVerifyPostBean: SendVerifyPostBean) {
//        RetrofitBuilder.httpGo {
//            mService?.sendVerifyCode(RetrofitBuilder.getRequestBody(sendVerifyPostBean))
//        }.observeState(lifecycleOwner,{
//            onSuccess {
//                Log.i("SSS","send-verify--$it")
//                Log.i("SSS", "send---verify--code>${it.sendVerifyCodeSuccessVo.effectiveSeconds}----success-${it.sendVerifyCodeSuccessVo.sendSuccess}")
//            }
//            onFailure { msg, code ->
//                Log.i("SSS", "error--msg--$msg---code---$code>")
//            }
//        })
//        GlobalScope.launch {
//            RetrofitBuilder.httpGo {
//                mService?.sendVerifyCode(RetrofitBuilder.getRequestBody(sendVerifyPostBean))
//            }.collect {
//                if(it.code == 0){
//
//                }
//            }
//        }
//        RetrofitBuilder.httpGo { mService?.sendVerifyCode(RetrofitBuilder.getRequestBody(sendVerifyPostBean)) }
//            .collectState(activity) {
//                onSuccess {
//
//                }
//                onFailure { msg, code ->
//
//                }
//            }

        RetrofitBuilder.start(Dispatchers.IO, {
            onSuccess {
                Log.i("SSS", "sender----$it")
            }
            onFailure { msg, code ->
                Log.i("SSS", "code--$code--msg---$msg")
            }
        }) { mService?.sendVerifyCode(RetrofitBuilder.getRequestBody(sendVerifyPostBean)) }

    }

    suspend fun doSomethingUsefulOne(): Int {
        delay(1000L) // 假设我们在这里做了些有用的事
        return 13
    }

    suspend fun doSomethingUsefulTwo(): Int {
        delay(1000L) // 假设我们在这里也做了些有用的事
        return 29
    }

    override fun bindService(): MainApiService {
        return RetrofitBuilder.createApi(activity!!)
    }

}