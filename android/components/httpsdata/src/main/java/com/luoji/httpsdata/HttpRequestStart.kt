package com.luoji.httpsdata

import android.app.Activity
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
//import com.lzy.okgo.OkGo
//import com.lzy.okgo.callback.StringCallback
//import com.lzy.okgo.model.Response
import java.lang.Exception
import com.google.gson.reflect.TypeToken
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 *Author:Ace
 *Date:On 2021/9/1
 */
abstract class HttpRequestStart<D>(val httpRequestCallBack: HttpRequestCallBack?){

  companion object{
    val HAS_DATA = "HAS_DATA"
    val HAS_NO_DATA = "HAS_NO_DATA"
  }

  fun startNoResponse(activity: Activity?, api: String, type:String){
    when(type){
      RequestConfig.GET->httpRequestGetNoResponse(activity,api)
      RequestConfig.POST->httpRequestPostNoResponse(activity,api)
    }
  }
  fun start(activity: Activity?, api: String, type:String,dClass: Class<D>){
    when(type){
      RequestConfig.GET->httpRequestGet(activity,api,dClass)
      RequestConfig.POST->httpRequestPost(activity,api,dClass)
    }
  }

  /**
   * post 请求带body参数 带返回数据
   */
  fun startPostUpBody(activity: Activity?, api: String,jsonValue:String,dClass: Class<D>){
      httpRequestPostUpBody(activity,api,jsonValue,dClass)
  }
  /**
   * post 请求带body参数 无返回数据
   */
  fun startPostUpBodyNoResponse(activity: Activity?, api: String,jsonValue:String){
    httpRequestPostUpBodyNoResponse(activity,api,jsonValue)
  }

  /**
   * POST 请求带body参数 带返回数据
   */
  fun httpRequestPostUpBody(activity: Activity?,api:String,jsonValue:String,dClass: Class<D>){
//    OkGo.post<String>(api)
//      .headers(HttpCustomerHeader.getHeader(activity,jsonValue))
//      .upJson(jsonValue)
//      .tag(activity)
//      .execute(object :StringCallback(){
//        override fun onSuccess(response: Response<String>) {
//          dataProcessing(response,dClass, HAS_DATA)
//        }
//
//        override fun onError(response: Response<String>?) {
//          super.onError(response)
//          response?.let { logicRequestFail(it.code()) }
//        }
//      })
  }

  /**
   * POST 请求带body参数 无返回数据
   */
  fun httpRequestPostUpBodyNoResponse(activity: Activity?,api:String,jsonValue:String){
//    OkGo.post<String>(api)
//      .headers(HttpCustomerHeader.getHeader(activity,jsonValue))
//      .upJson(jsonValue)
//      .tag(activity)
//      .execute(object :StringCallback(){
//        override fun onSuccess(response: Response<String>) {
//          dataProcessing(response,null, HAS_NO_DATA)
//        }
//
//        override fun onError(response: Response<String>?) {
//          super.onError(response)
//          response?.let { logicRequestFail(it.code()) }
//        }
//      })
  }

  /**
   * POST 请求不带返回数据
   */
  fun httpRequestPostNoResponse(activity: Activity?,api:String){
//    OkGo.post<String>(api)
//      .headers(HttpCustomerHeader.getHeader(activity,""))
//      .tag(activity)
//      .execute(object :StringCallback(){
//        override fun onSuccess(response: Response<String>?) {
//          dataProcessing(response,null, HAS_NO_DATA)
//        }
//
//        override fun onError(response: Response<String>?) {
//          super.onError(response)
//          response?.let { logicRequestFail(it.code()) }
//        }
//      })
  }

  /**
   * POST 请求带返回数据
   */
  fun httpRequestPost(activity: Activity?,api:String,dClass: Class<D>){
//    OkGo.post<String>(api)
//      .headers(HttpCustomerHeader.getHeader(activity,""))
//      .tag(activity)
//      .execute(object :StringCallback(){
//        override fun onSuccess(response: Response<String>) {
//          dataProcessing(response,dClass, HAS_DATA)
//        }
//
//        override fun onError(response: Response<String>?) {
//          super.onError(response)
//          response?.let { logicRequestFail(it.code()) }
//        }
//      })
  }

  /**
   * GET 请求不带返回数据
   */
  fun httpRequestGetNoResponse(activity: Activity?,api:String){
//    OkGo.get<String>(api)
//      .headers(HttpCustomerHeader.getHeader(activity,""))
//      .tag(activity)
//      .execute(object :StringCallback(){
//        override fun onSuccess(response: Response<String>?) {
//          dataProcessing(response,null, HAS_NO_DATA)
//        }
//
//        override fun onError(response: Response<String>?) {
//          super.onError(response)
//          response?.let { logicRequestFail(it.code()) }
//        }
//      })
  }

  /**
   * GET 请求带返回数据
   */
  fun httpRequestGet(activity: Activity?,api:String,dClass: Class<D>){
//    OkGo.get<String>(api)
////      .headers(HttpCustomerHeader.getHeader(activity,""))
//      .tag(activity)
//      .execute(object :StringCallback(){
//        override fun onSuccess(response: Response<String>?) {
//          dataProcessing(response,dClass, HAS_DATA)
//        }
//
//        override fun onError(response: Response<String>?) {
//          super.onError(response)
//          response?.let { logicRequestFail(it.code()) }
//        }
//      })
  }

//  /**
//   * 数据处理
//   */
//  fun dataProcessing(response:Response<String>?,dClass:Class<D>?,hasDataType:String){
//    var objectJson = JsonObject()
//    try {
//      val jsonElement = Gson().fromJson(response?.body(),JsonElement::class.java)
//      objectJson = jsonElement.asJsonObject
//      objectJson?.let {
//        val code = it.get(RequestConfig.CODE).asString
//        val message: String = it.get(RequestConfig.MESSAGE).toString()
//        val data = it.get("data").toString()
//        when(code){
//          RequestCode.REQUEST_SUCCESS-> {
//            if(hasDataType == HAS_DATA){
//              Log.i("SSS","response?.body()--->${response?.body()}")
////              val responseBean = ResponseGson.dataFromJsonObject(response?.body(),dClass)
////              val type: Type = object : TypeToken<ResponseBean<D>?>() {}.type
//              val type: Type? =
//                (javaClass.genericSuperclass as ParameterizedType?)?.actualTypeArguments?.get(0)
////              val responseBean:ResponseBean<D> = Gson().fromJson(response?.body(), type)
//
//              val responseBean2:D = Gson().fromJson(data, type)
//
////              Log.i("SSS","responseBean---${JSON.toJSONString(responseBean)}")
//              Log.i("SSS","responseBean2---${JSON.toJSONString(responseBean2)}")
//              requestSuccess(message,code,responseBean2)
//            } else{
//              requestSuccess(message,code,null)
//            }
//          }
//          RequestCode.FORCE_UPDATE->httpRequestCallBack?.forceUpdate()
//          RequestCode.FORCE_SIGN_OUT->httpRequestCallBack?.forceSignOut()
//          else ->requestFailed(message,code)
//        }
//      }
//    }catch (exception:Exception){
//      exception.printStackTrace()
//    }
//  }

  /**
   * 网络错误
   */
  fun logicRequestFail(code:Int){
    if("$code".equals(RequestCode.CONNECT_FAILED)){
      httpRequestCallBack?.netError()
    } else{
      requestFailed("NET ERROR",RequestCode.CONNECT_FAILED_CODE)
    }
  }

  abstract fun requestSuccess(message:String?,code:String,data:D?)
//  abstract fun requestSuccess(message:String?,code:String,data:ResponseBean<D>?)
  abstract fun requestFailed(message:String?,code:String)

}