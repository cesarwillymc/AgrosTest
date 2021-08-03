package com.cesarwillymc.agrostest.presentation.main.ui.dashboard.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cesarwillymc.agrostest.common.getScreenWidth
import com.cesarwillymc.agrostest.core.model.Image
import com.cesarwillymc.agrostest.databinding.LayoutViewholderImageBinding
import com.google.android.flexbox.FlexboxLayoutManager


class ImageDashboarddapter(private val activity: Activity) :
    RecyclerView.Adapter<ImageDashboarddapter.ViewHolder>() {

    var listImages: List<Image> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            LayoutViewholderImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = listImages.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(listImages[position], position)
    }

    fun updateData(data: List<Image>?) {
        listImages = data ?: listOf()
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: LayoutViewholderImageBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(image: Image, position: Int) {
            binding.model = image
            binding.executePendingBindings()
            val lp = binding.imageview.layoutParams
            if (lp is FlexboxLayoutManager.LayoutParams) {

                if (position == (listImages.size - 1) && listImages.size % 2 != 0) {

                    lp.width = getScreenWidth(activity) - 20
                } else {
                    lp.width = getScreenWidth(activity) / 2 - 10
                }

            }

        }
    }


}