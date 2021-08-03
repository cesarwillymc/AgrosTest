package com.cesarwillymc.agrostest.presentation.main.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cesarwillymc.agrostest.core.model.Image
import com.cesarwillymc.agrostest.databinding.LayoutImageBinding

class ImageHomeAdapter(private val listener:(Image)->Unit): RecyclerView.Adapter<ImageHomeAdapter.ViewHolder>() {

    var listImages:List<Image> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :ViewHolder {
        val binding = LayoutImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    override fun getItemCount() = listImages.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listImages[position],position)
    }
    fun updateData(data: List<Image>?){
        listImages = data ?: listOf()
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: LayoutImageBinding):RecyclerView.ViewHolder(binding.root){


        fun bind(image: Image, position: Int) {
            binding.model = image
            binding.executePendingBindings()
            binding.root.setOnClickListener {
                listener.invoke(image)
            }
        }
    }



}