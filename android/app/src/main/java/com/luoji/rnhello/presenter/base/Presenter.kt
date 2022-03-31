package com.luoji.rnhello.presenter.base

import android.app.Activity
import com.luoji.httpsdata.HttpRequestCallBack

/**
 *Author:Ace
 *Date:On 2021/9/1
 */
interface Presenter<V: MvvmView> {
  fun attachApi()
  fun attachActivity(dispatchActivity: Activity?)
  fun attachHttpCallBack(callBack: HttpRequestCallBack)
}