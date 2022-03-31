package com.luoji.retrofitrxjava.base

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModelProvider
import com.luoji.retrofitrxjava.presenter.base.MvvmView
import com.luoji.retrofitrxjava.presenter.base.Presenter
import com.luoji.common.customerui.LoadingView
import com.luoji.common.utils.TitleBar
import com.luoji.httpsdata.HttpRequestCallBack
import com.luoji.retrofitrxjava.R
import me.drakeet.support.toast.ToastCompat
import org.greenrobot.eventbus.EventBus

/**
 *Author:Ace
 *Date:On 2021/9/1
 */
abstract class BaseActivity<T, VM : BaseViewModel<T>, DB> :AppCompatActivity(),
  MvvmView,LifecycleOwner{

  protected var activity:Activity = this
  //管理生命周期
  protected var lifeCycleRegister = LifecycleRegistry(this)
  //DataBinding
  protected var dataBinding:DB?=null
  //存储状态
  protected var viewModel:VM? = null
  //订阅发布
  protected var eventBus: EventBus = EventBus.getDefault()
  //加载Loading
  var loadingView:LoadingView = LoadingView(this)

  protected abstract fun onShowViewById():Int

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if(attachTitleText() == null || attachTitleText() == ""){
      dataBinding = setContentView(this, onShowViewById())
    } else{
      setTitleModel()
    }

    lifeCycleRegister.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)

    viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(
      this.attachViewModel()
    )

    viewModel?.bindModel(this,this)

    //初始化Loading
    loadingView.initDialog()

    //初始化TitleBar
    initTitleBar()

    //逻辑开始
    kinit()
  }

  abstract fun kinit()

  protected abstract fun attachViewModel():Class<VM>

  /**
   * 设置Title导航栏
   */
  @SuppressLint("InflateParams") fun setTitleModel(){
    val viewGroup = LayoutInflater.from(this).inflate(R.layout.layout_base_container,null)
    val frameLayout:FrameLayout = viewGroup.findViewById(R.id.base_container_framelayout)

    val textViewTitle:TextView = viewGroup.findViewById(R.id.tv_base_title)
    val relatArrow:RelativeLayout = viewGroup.findViewById(R.id.base_title_relat_back)
    textViewTitle.text = attachTitleText()
    relatArrow.setOnClickListener {
      finish()
    }

    val viewActivity = LayoutInflater.from(this).inflate(onShowViewById(),null)

    dataBinding = DataBindingUtil.bind(viewActivity)

    frameLayout.addView(viewActivity)
    setContentView(viewGroup)
  }

  abstract fun attachTitleText():String?

  private fun initTitleBar(){
    setTitleBarColor(R.color.white)
    TitleBar.statusBarLMode(this)
  }

  /**
   * 设置TitleBar
   */
  @SuppressLint("ObsoleteSdkInt")
  private fun setTitleBarColor(colorId: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
      ) {
        val activityWindowConfig = window
        activityWindowConfig.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        activityWindowConfig.statusBarColor = ContextCompat.getColor(this, colorId)
      } else {
        val activityWindowConfig = window
        activityWindowConfig.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        activityWindowConfig.statusBarColor =ContextCompat.getColor(this, R.color.white)
      }
    }
  }

  /**
   * Toast
   */
  fun showToast(toast: String){
    ToastCompat.makeText(activity, toast, Toast.LENGTH_LONG).show()
  }
  fun showToastShort(toast: String){
    ToastCompat.makeText(activity, toast, Toast.LENGTH_SHORT).show()
  }

  /**
   * Loading
   */
  fun showLoading(message: String, cancel: Boolean){
    if(activity.isFinishing || activity.isDestroyed){
      return
    }
    loadingView.showDialog(message, cancel)
  }
  fun showLoading(message: String){
    if(activity.isFinishing || activity.isDestroyed){
      return
    }
    loadingView.showDialog(message)
  }
  fun showLoading(cancel: Boolean){
    if(activity.isFinishing || activity.isDestroyed){
      return
    }
    loadingView.showDialog(cancel)
  }
  fun showLoading(){
    if(activity.isFinishing || activity.isDestroyed){
      return
    }
    loadingView.showDialog()
  }
  fun dismissLoading(){
    loadingView.dismissDialog()
  }

  /**
   * 生命周期管理
   */
  override fun onStart() {
    super.onStart()
    lifeCycleRegister.handleLifecycleEvent(Lifecycle.Event.ON_START)
  }

  override fun onResume() {
    super.onResume()
    lifeCycleRegister.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
  }

  override fun onPause() {
    super.onPause()
    lifeCycleRegister.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  }

  override fun onDestroy() {
    super.onDestroy()
    lifeCycleRegister.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  }

}