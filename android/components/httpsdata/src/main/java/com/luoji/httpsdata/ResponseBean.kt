package com.luoji.httpsdata

import com.luoji.httpsdata.RequestCode.NET_ERROR

/**
 *Author:Ace
 *Date:On 2021/9/1
 */
open class ResponseBean<T>(override val code: Int = NET_ERROR,
                           override val msg: String = "",
                           override val data: T?=null):BaseResponseBean<T>()

abstract class BaseResponseBean<T>{
    abstract val code:Int
    abstract val msg:String
    abstract val data:T?
}
