package com.luoji.httpsdata

import com.google.gson.Gson
import java.lang.reflect.Type

/**
 *Author:Ace
 *Date:On 2021/9/1
 */
object ResponseGson {

  var mGsonValue: Gson? = Gson()

  fun <T> dataFromJsonArray(
    jsonValue: String?, tClassValue: Class<T>?
  ): ResponseBean<List<T>?>? {
    var paramsTypeValue: Type? = null
    try {
      paramsTypeValue = ResponseType.newInstance(ResponseBean::class.java)
        .beginRequestSubType(MutableList::class.java)
        .addMakerParam(tClassValue)
        ?.requestSubTypeOk()
        ?.makerBuild()
    } catch (e: Exception) {
      e.printStackTrace()
    }
    return mGsonValue!!.fromJson(jsonValue, paramsTypeValue)
  }

  fun <T> dataFromJsonObject(
    jsonValue: String?, tClassValue: Class<T>?
  ): ResponseBean<T>? {
    var paramsTypeValue: Type? = null
    try {
      paramsTypeValue = ResponseType.newInstance(
        ResponseBean::class.java
      ).addMakerParam(tClassValue)?.makerBuild()
    } catch (e: Exception) {
      e.printStackTrace()
    }
    return mGsonValue!!.fromJson(jsonValue, paramsTypeValue)
  }
}