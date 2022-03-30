package com.luoji.common.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 *Author:Ace
 *Date:On 2021/9/2
 */
abstract class BaseRecyclerViewAdapter<T,DB:ViewDataBinding>(
  open var datas:MutableList<T>,
  open val context: Context,open val baseRecyclerViewCallBack: BaseRecyclerViewCallBack): RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseRecyclerViewHolder<DB>>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewHolder<DB> {
    val itemDataBinding:DB = DataBindingUtil.inflate(LayoutInflater.from(parent.context), attachLayout(),parent,false)
    return BaseRecyclerViewHolder(itemDataBinding.root,itemDataBinding)
  }

  override fun onBindViewHolder(holder: BaseRecyclerViewHolder<DB>, position: Int) {
    return onBaseBindViewHolder(holder,position)
  }

  override fun getItemCount(): Int {
    return datas.size
  }

  fun addNewList(list:MutableList<T>){
    datas.clear()
    datas.addAll(list)
    notifyDataSetChanged()
  }

  fun addAll(list: MutableList<T>){
    datas.addAll(list)
    notifyDataSetChanged()
  }

  interface BaseRecyclerViewCallBack{
    fun onClickListener(position:Int)
  }

  class BaseRecyclerViewHolder<DB:ViewDataBinding>(val itemView: View,val itemDataBinding: DB) : RecyclerView.ViewHolder(itemView) {

  }

  abstract fun onBaseBindViewHolder(holder:BaseRecyclerViewHolder<DB>,position: Int)
  abstract fun attachLayout():Int
}