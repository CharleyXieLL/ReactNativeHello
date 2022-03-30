package com.luoji.retrofitrxjava.base

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.luoji.retrofitrxjava.presenter.base.MvvmView
import com.luoji.retrofitrxjava.presenter.base.Presenter
import com.luoji.common.customerui.LoadingView
import com.luoji.httpsdata.HttpRequestCallBack
import me.drakeet.support.toast.ToastCompat
import org.greenrobot.eventbus.EventBus

/**
 * Author:Ace
 * Date:On 2021/9/3
 */
abstract class BaseFragment<P: Presenter<MvvmView>,VM : ViewModel, DB:ViewDataBinding>: Fragment(),
    MvvmView,
  LifecycleOwner {

  protected var activity: Activity?=null
  //管理生命周期
  protected var lifeCycleRegister = LifecycleRegistry(this)
  //DataBinding
  protected var dataBinding:DB?=null
  //存储状态
  protected var viewModel:VM? = null
  //订阅发布
  protected var eventBus: EventBus = EventBus.getDefault()
  //加载Loading
  var loadingView: LoadingView? = null

  private var basePresenter:P?=null

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    dataBinding = DataBindingUtil.inflate(inflater,onShowViewById(),container,false)
    Log.i("SSS","data is null --${dataBinding==null}")
    return dataBinding?.root
  }

  abstract fun onShowViewById():Int

  override fun onStart() {
    super.onStart()
    lifeCycleRegister.handleLifecycleEvent(Lifecycle.Event.ON_START)
    activity = requireActivity()

    //初始化Loading
    loadingView = LoadingView(activity)
    loadingView?.initDialog()

    setPresenter(attachPresenter())

    viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(activity?.application!!)).get(
      this.attachViewModel()
    )
    kfragmentInit()
  }

  abstract fun kfragmentInit()

  protected abstract fun attachViewModel():Class<VM>

  protected abstract fun attachPresenter():P
  protected fun getPresenter(): P? {
    return basePresenter
  }

  private fun setPresenter(presenter: P){
    basePresenter = presenter
    basePresenter?.apply {
      attachActivity(activity)
      attachApi()
      attachHttpCallBack(object : HttpRequestCallBack {
        override fun forceUpdate() {
          Log.i("forceUpdate", "")
        }

        override fun forceSignOut() {
          Log.i("forceSignOut", "")
        }

        override fun netError() {
          Log.i("netError", "")
        }
      })
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
    activity?.let {
      if(it.isFinishing || it.isDestroyed){
        return
      }
      loadingView?.showDialog(message, cancel)
    }
  }
  fun showLoading(message: String){
    activity?.let {
      if(it.isFinishing || it.isDestroyed){
        return
      }
      loadingView?.showDialog(message)
    }
  }
  fun showLoading(cancel: Boolean){
    activity?.let {
      if(it.isFinishing || it.isDestroyed){
        return
      }
      loadingView?.showDialog(cancel)
    }
  }
  fun showLoading(){
    activity?.let {
      if(it.isFinishing || it.isDestroyed){
        return
      }
      loadingView?.showDialog()
    }
  }
  fun dismissLoading(){
    loadingView?.dismissDialog()
  }

  /**
   * 生命周期管理
   */
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    lifeCycleRegister.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
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