package com.luoji.rnhello.react

import android.os.Bundle
import com.facebook.react.ReactActivity
import com.luoji.common.utils.TitleBar

/**
 * Author:Ace
 * Date:On 2022/3/29
 */
public class MyReactActivity : ReactActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TitleBar.changeTransparencyBar(this)
    }

    override fun getMainComponentName(): String {
        return "reactdemo"
    }
}