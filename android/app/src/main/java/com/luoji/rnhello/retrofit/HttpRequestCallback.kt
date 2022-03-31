package com.luoji.rnhello.retrofit

/**
 * Author:Ace
 * Date:On 2022/1/12
 */
typealias OnSuccessCallback<T> = (data: T) -> Unit
typealias OnFailureCallback = (msg:String,code:Int) -> Unit
typealias OnForceLogoutCallback = () -> Unit

class HttpRequestCallback<T> {

    var successCallback: OnSuccessCallback<T>? = null
    var failureCallback: OnFailureCallback? = null
    var forceLogoutCallback:OnForceLogoutCallback?=null

    fun onSuccess(block: OnSuccessCallback<T>) {
        successCallback = block
    }

    fun onFailure(block: OnFailureCallback) {
        failureCallback = block
    }

    fun onForceLogout(block:OnForceLogoutCallback){
        forceLogoutCallback = block
    }
}