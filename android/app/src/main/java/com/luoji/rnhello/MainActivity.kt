package com.luoji.rnhello

import com.luoji.rnhello.base.BaseActivity
import com.luoji.rnhello.databinding.ActivityMainBinding
import com.luoji.rnhello.retrofit.api.MainApiService

/**
 * Author:Ace
 * Date:On 2022/1/5
 */
class MainActivity : BaseActivity<MainApiService, MainViewModel, ActivityMainBinding>() {

    override fun onShowViewById(): Int {
        return R.layout.activity_main
    }

    override fun kinit() {
        dataBinding?.mainClick = this
    }

    fun home() {
        viewModel?.getHome()
    }

    override fun attachViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun attachTitleText(): String? {
        return null
    }

    override fun requestError(message: String, code: String) {
        showToast(message)
        dismissLoading()
    }

}