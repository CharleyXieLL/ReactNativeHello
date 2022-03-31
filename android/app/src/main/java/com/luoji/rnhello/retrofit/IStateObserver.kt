package com.luoji.rnhello.retrofit

import androidx.lifecycle.Observer
import com.luoji.httpsdata.ResponseBean

/**
 * Author:Ace
 * Date:On 2022/1/12
 */
interface IStateObserver<T> : Observer<ResponseBean<T>> {

    override fun onChanged(response: ResponseBean<T>?) {
        startLogic(response)
    }

    fun startLogic(response: ResponseBean<T>?)
}