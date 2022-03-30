package com.luoji.httpsdata

import java.lang.reflect.Type
import java.util.ArrayList

/**
 *Author:Ace
 *Date:On 2021/9/1
 */
class ResponseType(val aClassValue:Class<*>?,val responseType:ResponseType?) {
  
  private val typeArrayListValue: MutableList<Type> = ArrayList()

  companion object{
    fun newInstance(aClassValue: Class<*>?): ResponseType {
      return ResponseType(aClassValue, null)
    }

    private fun newInstance(
      aClassValue: Class<*>, responseType: ResponseType
    ): ResponseType {
      return ResponseType(aClassValue, responseType)
    }
  }

  fun beginRequestSubType(aClassValue: Class<*>): ResponseType {
    return newInstance(aClassValue, this)
  }

  fun requestSubTypeOk(): ResponseType {
    if (responseType == null) {
      try {
        throw Exception("expect beginRequestHttpSubType() before endRequestHttpSubTypeOk()")
      } catch (e: Exception) {
        e.printStackTrace()
      }
    }
    responseType!!.addMakerParam(acquireMakerType())
    return responseType
  }

  fun addMakerParam(aClassValue: Class<*>?): ResponseType? {
    return addMakerParam(aClassValue as Type?)
  }

  private fun addMakerParam(typeValue: Type?): ResponseType {
    if (typeValue == null) {
      throw NullPointerException("addMakerParam expect not null Type")
    }
    typeArrayListValue.add(typeValue)
    return this
  }

  @Throws(Exception::class) fun makerBuild(): Type? {
    if (responseType != null) {
      throw Exception("expect endRequestHttpSubTypeOk() before makerBuild()")
    }
    return acquireMakerType()
  }

  private fun acquireMakerType(): Type? {
    return if (typeArrayListValue.isEmpty()) {
      aClassValue
    } else HttpParams(
      aClassValue, typeArrayListValue.toTypedArray(), null
    )
  }
}