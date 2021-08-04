package com.cesarwillymc.agrostest.presentation.main.ui.home


import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.cesarwillymc.agrostest.R
import com.cesarwillymc.agrostest.app.MyApp
import com.cesarwillymc.agrostest.base.BaseFragment
import com.cesarwillymc.agrostest.databinding.FragmentHomeBinding
import com.cesarwillymc.agrostest.presentation.main.ui.home.adapter.ImageHomeAdapter
import com.cesarwillymc.agrostest.presentation.main.ui.home.di.DaggerHomeComponent
import com.cesarwillymc.agrostest.presentation.main.ui.home.di.HomeModule

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    override fun onInitDependencyInjection() {
        DaggerHomeComponent.builder().coreComponent(MyApp.coreComponent(requireContext()))
            .homeModule(HomeModule(this)).build().inject(this)
    }

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inicializarRV()
        viewModel.onClick = {
            viewBinding.edtUrlImg.setText("")
            verifyUrl(it)
        }
        viewModel.listImage.observe(viewLifecycleOwner) {
            imageAdapter.updateData(it)
        }
    }

    private fun verifyUrl(image: String) {
        Glide.with(this)
            .load(image)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    viewModel.inserImage(image)
                    return false
                }

            }).placeholder(R.drawable.loading).error(R.drawable.nofound)
            .into(viewBinding.imgImg)
    }

    private lateinit var imageAdapter: ImageHomeAdapter

    private fun inicializarRV() {
        imageAdapter = ImageHomeAdapter {
            Glide.with(this)
                .load(it.id).placeholder(R.drawable.loading).error(R.drawable.nofound)
                .into(viewBinding.imgImg)
        }
        val manager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        viewBinding.rvImages.apply {
            layoutManager = manager
            adapter = imageAdapter
        }

        val itemTouchHelper = ItemTouchHelper(simpleCallbackTouch)
        itemTouchHelper.attachToRecyclerView(viewBinding.rvImages)
    }

    private val simpleCallbackTouch =
        object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.DOWN or ItemTouchHelper.UP) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val items = imageAdapter.listImages
                viewModel.deleteImage(items[position])
            }
        }


}