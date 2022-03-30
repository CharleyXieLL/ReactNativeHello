package com.luoji.retrofitrxjava.base

import android.annotation.SuppressLint
import android.app.Activity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel

/**
 * Author:Ace
 * Date:On 2022/1/5
 */
abstract class BaseViewModel<T>: ViewModel() {

    @SuppressLint("StaticFieldLeak")
    protected var activity:Activity?=null

    protected var lifecycleOwner:LifecycleOwner?=null

    protected var mService:T?=null

    public fun bindModel(_activity: Activity,_lifecycleOwner: LifecycleOwner){
        activity = _activity
        lifecycleOwner = _lifecycleOwner
        mService = bindService()
    }

    abstract fun bindService():T
}