package com.luoji.rnhello.base

import com.luoji.rnhello.R

/**
 * Author:Ace
 * Date:On 2021/9/3
 */
data class BaseTitleData(var _backType:Int, var titleText: String?){

  var backType = _backType

  var backResource:Int = R.drawable.ic_baseline_arrow_back_ios_24
    get() = when(backType){
      NORMAL_BACK -> R.drawable.ic_baseline_arrow_back_ios_24
      else -> R.drawable.ic_baseline_arrow_back_ios_24
    }
    set(value) {
      field = value
    }

  companion object{
    const val NORMAL_BACK = 1
  }
}