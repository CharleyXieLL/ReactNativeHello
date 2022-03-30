package com.luoji.common.customerui.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.luoji.common.R

/**
 * Author:Ace
 * Date:On 2021/9/4
 * Dialog 基础类
 */
abstract class BaseDialog<DB:ViewDataBinding>(open var activity: Activity) {

  private var dialog:Dialog?=null
  protected var dialogBinding:DB?=null

  fun initDialog(){
    dialog = Dialog(activity);

    val dialogView:View = LayoutInflater.from(activity).inflate(attachDialogLayout(),null,false)
    dialogBinding = DataBindingUtil.bind(dialogView)

    dialog?.apply {
      setCancelable(true)
      window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
      setContentView(dialogView)
    }

    val window = dialog?.window
    window?.apply {
      setGravity(Gravity.CENTER)
      decorView.setPadding(0,0,0,0)
      setWindowAnimations(R.style.BasePopAnimStyle)
    }

    val windowAttributes: WindowManager.LayoutParams? = window?.attributes
    windowAttributes?.width = WindowManager.LayoutParams.MATCH_PARENT
    windowAttributes?.height = WindowManager.LayoutParams.MATCH_PARENT
  }

  abstract fun attachDialogLayout():Int

  fun showDialog(){
    if(activity.isFinishing || activity.isDestroyed){
      return
    }
    dialog?.apply {
      dismiss()
      show()
    }
  }

  fun dismissDialog(){
    if(activity.isFinishing || activity.isDestroyed){
      return
    }
    dialog?.dismiss()
  }

}