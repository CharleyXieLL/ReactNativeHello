package com.luoji.common.customerui

import android.app.Activity
import android.app.Dialog
import android.view.Gravity
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.TextView
import com.luoji.common.R

/**
 *Author:Ace
 *Date:On 2021/9/1
 */
class LoadingView(val activity: Activity?) {
  var imageView:ImageView?=null
  var textView:TextView?=null
  var dialog:Dialog? = null
  var animation:Animation? = null

  fun initDialog(){
    dialog = activity?.let { Dialog(it, R.style.BaseLoadDialog) }
    dialog?.apply {
      setContentView(R.layout.base_loadingview)
      window?.attributes?.gravity = Gravity.CENTER
      if (activity != null) {
        setOwnerActivity(activity)
      }
      setCanceledOnTouchOutside(false)
      setCancelable(true)
    }
    animation = AnimationUtils.loadAnimation(activity,R.anim.anim_loadingview)
    animation?.setInterpolator(LinearInterpolator())
    imageView = dialog?.findViewById(R.id.img_base_load_view)
    textView = dialog?.findViewById(R.id.tv_base_load_view)
  }

  fun showDialog(message:String,cancel: Boolean){
    message?.let {
      textView?.visibility = VISIBLE
      textView?.setText(message)
      attachAnimation()
      dialog?.apply {
        dismiss()
        setCancelable(cancel)
        show()
      }
    }
  }

  fun showDialog(message:String){

    message?.let {
      textView?.visibility = VISIBLE
      textView?.setText(message)
      attachAnimation()
      dialog?.apply {
        dismiss()
        show()
      }
    }
  }

  fun showDialog(cancel:Boolean){
    textView?.visibility = GONE
    attachAnimation()
    dialog?.apply {
      dismiss()
      setCancelable(cancel)
      show()
    }
  }

  fun showDialog(){
    textView?.visibility = GONE
    attachAnimation()
    dialog?.apply {
      dismiss()
      show()
    }
  }

  fun dismissDialog(){
    dialog?.dismiss()
    imageView?.clearAnimation()
  }

  fun attachAnimation(){
    imageView?.animation = animation
    imageView?.startAnimation(animation)
  }

}