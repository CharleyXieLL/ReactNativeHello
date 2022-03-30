package com.luoji.common.utils

import android.content.Context

/**
 * Author:Ace
 * Date:On 2021/9/3
 * UI相关工具类
 */
object UIUtil {

  private var scale = 0

  /**
   * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
   */
  fun dip2px(context: Context, dpValue: Int): Int {
    if (scale == 0) {
      scale = context.resources.displayMetrics.density.toInt()
    }
    return (dpValue * scale).toInt()
  }

  /**
   * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
   */
  fun px2dip(context: Context, pxValue: Int): Int {
    if (scale == 0) {
      scale = context.resources.displayMetrics.density.toInt()
    }
    return (pxValue / scale).toInt()
  }
}