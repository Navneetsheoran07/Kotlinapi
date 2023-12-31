package com.sheoran.kotlinapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sheoran.kotlinapi.databinding.ItemDemoViewBinding

class DemoAdapter (var context: Context,var list:MutableList<DemoDataModelItem>) :RecyclerView.Adapter<DemoAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemoAdapter.ViewHolder {
      return  ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_demo_view,parent,false))
    }

    override fun onBindViewHolder(holder: DemoAdapter.ViewHolder, position: Int) {

        val itemViewModel =list[position]
        with(holder.binding){
            textViewId.text=itemViewModel.id.toString()
            tvTitle.text=itemViewModel.title
        }
    }

    override fun getItemCount(): Int {
       return  list.size
    }
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        val binding= ItemDemoViewBinding.bind(itemView)
    }
}