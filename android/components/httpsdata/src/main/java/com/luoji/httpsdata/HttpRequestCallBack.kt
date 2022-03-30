package com.luoji.httpsdata

/**
 *Author:Ace
 *Date:On 2021/9/1
 */
interface HttpRequestCallBack {
  fun forceUpdate()
  fun forceSignOut()
  fun netError()
}