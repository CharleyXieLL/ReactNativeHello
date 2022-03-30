package com.luoji.retrofitrxjava.presenter.main

import com.luoji.retrofitrxjava.presenter.api.MainApi
import com.luoji.retrofitrxjava.presenter.base.BasePresenter

/**
 * Author:Ace
 * Date:On 2022/1/5
 */
class MainPresenter: BasePresenter<MainApi>() {

    override fun api(): MainApi {
        return MainApi()
    }
}