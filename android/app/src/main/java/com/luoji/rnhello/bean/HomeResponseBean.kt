package com.luoji.rnhello.bean

/**
 * Author:Ace
 * Date:On 2022/3/31
 */
data class HomeResponseBean(
    var mainTitleList: MutableList<String>,
    var advertising: String,
    var ad2: MutableList<String>
) {

}