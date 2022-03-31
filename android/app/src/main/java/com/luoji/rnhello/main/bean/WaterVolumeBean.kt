package com.luoji.rnhello.main.bean

/**
 * Author:Ace
 * Date:On 2022/1/5
 */
data class WaterVolumeBean(
var timePointList:MutableList<String>,
var drinkVolumeCountList:MutableList<String>,
var average:Int
) {
}