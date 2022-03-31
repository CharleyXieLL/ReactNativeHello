package com.luoji.retrofitrxjava

import com.luoji.retrofitrxjava.base.BaseActivity
import com.luoji.retrofitrxjava.databinding.ActivityMainBinding
import com.luoji.retrofitrxjava.retrofit.api.MainApiService

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