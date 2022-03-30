package com.luoji.common.utils

import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Author:Ace
 * Date:On 2021/9/3
 * 修改NavBar的图标大小
 */
object NavBarUtil {
  fun setNavIconSize(view: BottomNavigationView,size:Int){
    val menuView: BottomNavigationMenuView = view.getChildAt(0) as BottomNavigationMenuView
    for(index in 0..menuView.childCount){
      val menuItem = menuView.getChildAt(index)
      menuItem?.let {
        val imageView:ImageView = menuItem.findViewById(com.google.android.material.R.id.navigation_bar_item_icon_view)
        imageView.layoutParams.width = size
        imageView.layoutParams.height = size
      }
    }
  }
}