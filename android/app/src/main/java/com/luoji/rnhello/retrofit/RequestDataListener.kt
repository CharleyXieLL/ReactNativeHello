package com.luoji.rnhello.retrofit

import android.content.Context
import android.util.Log
import com.luoji.httpsdata.ResponseBean
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

/**
 * Author:Ace
 * Date:On 2022/1/12
 */
//inline fun <T> LiveData<ResponseBean<T>>.observeState(
//    owner:LifecycleOwner?,
//    crossinline callback:HttpRequestCallback<T>.() -> Unit
//){
//    val requestCallback = HttpRequestCallback<T>().apply(callback)
//    observe(owner!!, object : IStateObserver<T> {
//        override fun startLogic(response: ResponseBean<T>?) {
//            when(response?.code){
//                RequestCode.SUCCESS->{
//                    requestCallback.successCallback?.invoke(response.data)
//                }
//                RequestCode.FORCE_LOGOUT->{
//                    Log.i("SSS","FORCE_LOGOUT")
////                    activity.finish()
////                    requestCallback.forceLogoutCallback?.invoke()
//                }
//                else ->{
//                    response?.let { requestCallback.failureCallback?.invoke(it.msg,it.code) }
//                }
//            }
//        }
//    })
//}

inline fun <T> Flow<ResponseBean<T>>.collectState(
    context: Context?,
    crossinline callback:HttpRequestCallback<T>.() -> Unit
){
    val requestCallback = HttpRequestCallback<T>().apply(callback)
    CoroutineScope(Dispatchers.Main).launch {
        collect {
            when(it.code){
                RequestCode.SUCCESS->{
                    requestCallback.successCallback?.invoke(it.data!!)
                }
                RequestCode.FORCE_LOGOUT->{
                    Log.i("SSS","FORCE_LOGOUT")
//                    activity.finish()
//                    requestCallback.forceLogoutCallback?.invoke()
                }
                else ->{
                    requestCallback.failureCallback?.invoke(it.msg,it.code)
                }
            }
        }
    }
}