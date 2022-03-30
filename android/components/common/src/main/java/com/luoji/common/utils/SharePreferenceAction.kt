package com.luoji.common.utils

import android.content.Context
import android.content.SharedPreferences

/**
 *Author:Ace
 *Date:On 2021/9/1
 * 持久化储存
 */
class SharePreferenceAction(val context:Context,var sharedName:String) {
  val sharedPreferences:SharedPreferences = context.getSharedPreferences(sharedName,Context.MODE_PRIVATE)
  val editor:SharedPreferences.Editor = sharedPreferences.edit()

  fun putBoolean(key:String,value:Boolean):SharedPreferences.Editor{
    return editor.putBoolean(key,value)
  }

  fun putInt(key: String,value: Int):SharedPreferences.Editor{
    return editor.putInt(key,value)
  }

  fun putString(key: String,value:String):SharedPreferences.Editor{
    return editor.putString(key,value)
  }

  fun getShareBoolean(key: String):Boolean{
    return sharedPreferences.getBoolean(key,false)
  }

  fun getShareInt(key: String):Int{
    return sharedPreferences.getInt(key,0)
  }

  fun getShareString(key: String): String? {
    return sharedPreferences.getString(key,null)
  }
}