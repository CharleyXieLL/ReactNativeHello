package com.luoji.common.utils

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager

/**
 * Author:Ace
 * Date:On 2021/9/3
 * 更改状态栏
 */
object TitleBar {

  @TargetApi(19)
  fun changeTransparencyBar(activity: Activity) {
    val window = activity.window
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      window.clearFlags(
        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
      )
      window.decorView.systemUiVisibility =
        (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
      window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
      window.statusBarColor = Color.TRANSPARENT
    } else
      window.setFlags(
        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
      )
  }

  @SuppressLint("ObsoleteSdkInt")
  fun statusBarLMode(activity: Activity): Int {
    var value = 0
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        activity.window
          .decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
      }
      value = 3
    }
    return value
  }

  @SuppressLint("PrivateApi")
  private fun setMiuiBarMode(
    window: Window?,
    bValue: Boolean
  ): Boolean {
    var b1Value = false
    if (window != null) {
      val aClassValue: Class<*> = window.javaClass
      try {
        val darkmodeflagValue: Int
        val layoutParamsValue =
          Class.forName("android.view.MiuiWindowManager\$LayoutParams")
        val barDarkModeValue =
          layoutParamsValue.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE")
        darkmodeflagValue =
          barDarkModeValue.getInt(layoutParamsValue)
        val setExtraFlagsValue = aClassValue.getMethod(
          "setExtraFlags",
          Int::class.javaPrimitiveType,
          Int::class.javaPrimitiveType
        )
        if (bValue) {
          setExtraFlagsValue.invoke(
            window,
            darkmodeflagValue,
            darkmodeflagValue
          )
        } else {
          setExtraFlagsValue.invoke(
            window,
            0,
            darkmodeflagValue
          )
        }
        b1Value = true
      } catch (eValue: Exception) {
        eValue.printStackTrace()
      }
    }
    return b1Value
  }
}