package com.luoji.retrofitrxjava.presenter.base

import android.app.Activity
import com.luoji.httpsdata.HttpRequestCallBack

/**
 *Author:Ace
 *Date:On 2021/9/1
 */
abstract class BasePresenter<A>: Presenter<MvvmView> {
  protected var api:A?=null
  protected var activity:Activity?=null

  protected abstract fun api():A

  protected var httpCallBack:HttpRequestCallBack?=null

  override fun attachApi() {
    api = api()
  }

  override fun attachActivity(dispatchActivity: Activity?) {
    activity = dispatchActivity
  }

  override fun attachHttpCallBack(callBack: HttpRequestCallBack) {
    this.httpCallBack = callBack
  }
}