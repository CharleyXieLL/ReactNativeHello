package com.luoji.retrofitrxjava.retrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.luoji.httpsdata.ResponseBean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

/**
 * Author:Ace
 * Date:On 2022/1/12
 */
abstract class BaseRequestAction {

//    protected fun <T> httpGo(request:suspend () -> ResponseBean<T>
//    ):LiveData<ResponseBean<T>> = runBlocking{
//        request()
//    }
}