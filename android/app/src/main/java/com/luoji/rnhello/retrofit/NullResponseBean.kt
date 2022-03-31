package com.luoji.rnhello.retrofit

import com.luoji.httpsdata.ResponseBean

/**
 * Author:Ace
 * Date:On 2022/1/21
 */
class NullResponseBean<T>(code: Int, msg: String, data: T) : ResponseBean<T>(code, msg, data) {}