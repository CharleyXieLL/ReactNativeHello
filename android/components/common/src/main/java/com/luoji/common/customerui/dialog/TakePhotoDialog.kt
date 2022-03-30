package com.luoji.common.customerui.dialog

import android.app.Activity
import com.luoji.common.R
import com.luoji.common.databinding.BaseTakephotoSelectDialogBinding

/**
 * Author:Ace
 * Date:On 2021/9/4
 * 选择照片 POP 弹框
 */
class TakePhotoDialog(override var activity: Activity, var cancel:Boolean,var takePhotoDialogListener:TakePhotoDialogListener):BaseDialog<BaseTakephotoSelectDialogBinding>(activity) {

  override fun attachDialogLayout(): Int {
    return R.layout.base_takephoto_select_dialog
  }

  fun setListener(){
    dialogBinding?.takePhotoDialogListener = this
  }

  fun onContentClick(){
    if(cancel){
      dismissDialog()
    }
  }

  fun takePhoto(){
    takePhotoDialogListener.takePhoto()
    dismissDialog()
  }

  fun selectAlbum(){
    takePhotoDialogListener.selectAlbum()
    dismissDialog()
  }

  fun cancel(){
    dismissDialog()
  }

  interface TakePhotoDialogListener{
    fun takePhoto()
    fun selectAlbum()
  }

  fun bindTakePhotoDialogListener(_takePhotoDialogListener:TakePhotoDialogListener){
    takePhotoDialogListener = _takePhotoDialogListener
  }
}