package com.luoji.retrofitrxjava

import android.util.Log
import com.luoji.retrofitrxjava.base.BaseViewModel
import com.luoji.retrofitrxjava.retrofit.*
import com.luoji.retrofitrxjava.retrofit.api.MainApiService
import kotlinx.coroutines.*

/**
 * Author:Ace
 * Date:On 2022/1/5
 */
class MainViewModel : BaseViewModel<MainApiService>() {

    fun getHome() {
        RetrofitBuilder.getInstance().start(Dispatchers.IO, {
            onSuccess {
                Log.i("SSS", "sender----$it")
            }
            onFailure { msg, code ->
                Log.i("SSS", "code--$code--msg---$msg")
            }
        }) { mService?.getHome() }

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
        return RetrofitBuilder.getInstance().createApi(activity!!)
    }

}