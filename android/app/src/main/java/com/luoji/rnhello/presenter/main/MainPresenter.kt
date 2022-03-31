package com.luoji.rnhello.presenter.main

import com.luoji.rnhello.presenter.api.MainApi
import com.luoji.rnhello.presenter.base.BasePresenter

/**
 * Author:Ace
 * Date:On 2022/1/5
 */
class MainPresenter: BasePresenter<MainApi>() {

    override fun api(): MainApi {
        return MainApi()
    }
}