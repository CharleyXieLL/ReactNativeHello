package com.luoji.httpsdata

import android.app.Activity
import android.content.Context
import com.luoji.common.utils.SharePreferenceAction
import com.luoji.common.utils.SharePreferenceData
import org.json.JSONObject

/**
 *Author:Ace
 *Date:On 2021/9/1
 * 请求头
 */
class HttpCustomerHeader {

  companion object{
    private const val VERSION_CODE="versionCode"
    private const val VERSION_NAME="versionName"
    private const val TOKEN="token"

    fun getHeader(activity: Activity?,body:String){
      val versionCode = 100
      val versionName = "1.0.0"
      val json = JSONObject()
      json.put(VERSION_CODE,versionCode)
      json.put(VERSION_NAME,versionName)
      json.put(TOKEN, if(activity == null)"" else SharePreferenceData.getToken(activity))

//      httpHeaders.put("basicParams",json.toString())
//      return httpHeaders
    }
  }

}