package com.elena_balakhnina.recycler.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


class ExampleRecyclerView<T, VB : ViewBinding>(

    private val factory : (LayoutInflater, ViewGroup, Boolean) -> VB,
    private val onItemClick : (T)->Unit = {},
    private val binding: T.(VB) -> Unit,
    diffUtil: DiffUtil.ItemCallback<T> = object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }

    }
) : ListAdapter<T, ExampleVH<VB>>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleVH<VB> {
        val viewBinding = factory(LayoutInflater.from(parent.context), parent, false)
        return ExampleVH(viewBinding).also { vh ->
            vh.itemView.setOnClickListener {
                val position = vh.adapterPosition
                if(position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    onItemClick(item)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ExampleVH<VB>, position: Int) {
        val item = getItem(position)
        binding.invoke(item, holder.binding)
    }
}

//ViewHolder с параметром с типом T
class ExampleVH<T : ViewBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)