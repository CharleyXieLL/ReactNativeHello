package com.luoji.common.utils

import android.content.Context

/**
 *Author:Ace
 *Date:On 2021/9/1
 * 轻量型本地化存储
 */
class SharePreferenceData {

  companion object{
    private const val TOKEN = "TOKEN"
    private const val SHARED_NAME = "AndroidStart"

    fun setToken(context:Context,token:String){
      SharePreferenceAction(context,SHARED_NAME).putString(TOKEN,token)
    }
    fun getToken(context: Context):String?{
      return SharePreferenceAction(context, SHARED_NAME).getShareString(TOKEN)
    }


  }
}