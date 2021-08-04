package com.cesarwillymc.agrostest.presentation.main.ui.dashboard.adapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cesarwillymc.agrostest.core.model.Image
import com.cesarwillymc.agrostest.databinding.LayoutViewholderImageBinding
import com.cesarwillymc.agrostest.presentation.main.ui.dashboard.common.isLastItemandInpair


class ImageDashboarddapter :
    RecyclerView.Adapter<ImageDashboarddapter.ViewHolder>() {

    var listImages: List<Image> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val containerWidth = parent.measuredWidth
        val binding =
            LayoutViewholderImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, containerWidth)
    }

    override fun getItemCount() = listImages.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listImages[position], position)
    }

    fun updateData(data: List<Image>?) {
        listImages = data ?: listOf()
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        private val binding: LayoutViewholderImageBinding,
        private val containerWidth: Int
    ) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(image: Image, position: Int) {
            if (isLastItemandInpair(listImages.size, position)) {
                binding.imageview.layoutParams.width = containerWidth
            } else {
                binding.imageview.layoutParams.width = containerWidth / 2
            }

            binding.model = image
            binding.executePendingBindings()

        }
    }


}