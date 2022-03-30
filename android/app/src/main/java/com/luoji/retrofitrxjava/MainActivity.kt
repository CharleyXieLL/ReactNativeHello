package com.luoji.retrofitrxjava

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.luoji.retrofitrxjava.base.BaseActivity
import com.luoji.retrofitrxjava.bean.SendVerifyPostBean
import com.luoji.retrofitrxjava.databinding.ActivityMainBinding
import com.luoji.retrofitrxjava.retrofit.*
import kotlinx.coroutines.*

/**
 * Author:Ace
 * Date:On 2022/1/5
 */
class MainActivity : BaseActivity<MainApiService, MainViewModel, ActivityMainBinding>() {

    override fun onShowViewById(): Int {
        return R.layout.activity_main
    }

    override fun kinit() {
        dataBinding?.mainClick = this
    }

    fun getWaterList() {
        viewModel?.sendVerify(SendVerifyPostBean("6366532525"))
//        GlobalScope.launch {
//            this.runCatching {
//                getString()
//            }.onSuccess {
//                Log.i("SSS","onSuccess->$it")
//            }.onFailure {
//                Log.i("SSS","onFailure->$it")
//            }
//
//        }

//        viewModel?.getWaterList()
//        RequestAction.getWaterList("123456123456",2).observeState(this){
//            onSuccess {
//                Log.i("SSS","waterlist-->$it")
//            }
//            onFailure { msg, code ->
//                Log.i("SSS","msg-->$msg---code-->$code")
//            }
//        }

//        start().observe(this, { value -> Log.i("SSS","value--$value") })

//        GlobalScope.launch {
//            val result = RetrofitBuilder.createApi<MainApiService>().getWaterList("123456123456",2)
//            Log.i("SSS","result--->$result")
//        }

//        RequestAction.httpGo {
////            RetrofitBuilder.createApi<MainApiService>().getWaterList("123456123456",2)
//            RequestSource.getWaterList("123456123456",2)
//        }.observeState(this,{
//            onSuccess {
//                Log.i("SSS","waterlist-->$it")
//            }
//            onFailure { msg, code ->  }
//        })

//        viewModel?.getWaterList()

//        start().observe(this,{
//            Log.i("SSS","observe--string--$it")
//        })
    }


    fun httpGo(block: suspend () -> String): LiveData<String> = liveData(Dispatchers.Default) {
        this.runCatching {
            Log.i("SSS", "block--start")
            block()
        }.onSuccess {
            Log.i("SSS", "onSuccess--string-->$it")
            emit(it)
        }.onFailure {
            Log.i("SSS", "onFailure--exception-->$it")
        }
    }

//    fun httpGo(block:suspend ()->LiveData<String>): LiveData<String> = runBlocking {
//        block()
//    }
//fun httpGo(block:suspend ()->LiveData<String>): LiveData<String> = runBlocking {
//    block()
//}

//    fun httpGo(context: CoroutineContext = Dispatchers.IO,
//                       block:suspend ()->String){
//
//    }

    suspend fun getString(): String {
//        val data = MutableLiveData<String>()
        val stringBuffer = StringBuffer()
        for (index in 0..5) {
            delay(500L)
            Log.i("SSS", "我是第--$index--行数据")
            stringBuffer.append("我是第--$index--行数据")
        }
//        data.postValue(stringBuffer.toString())
        return stringBuffer.toString()
    }
//
//    fun start() = httpGo { getString() }

    override fun attachViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun attachTitleText(): String? {
        return null
    }

    override fun requestError(message: String, code: String) {
        showToast(message)
        dismissLoading()
    }

}