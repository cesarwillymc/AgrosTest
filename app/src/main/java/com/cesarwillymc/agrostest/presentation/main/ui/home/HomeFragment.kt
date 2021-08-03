package com.cesarwillymc.agrostest.presentation.main.ui.home


import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.cesarwillymc.agrostest.R
import com.cesarwillymc.agrostest.app.MyApp
import com.cesarwillymc.agrostest.base.BaseFragment
import com.cesarwillymc.agrostest.databinding.FragmentHomeBinding
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
        viewModel.onClick = {
            verifyUrl(it)
        }

    }

    private fun verifyUrl(image: String) {
        Glide.with(this)
            .load(image)

            .listener(object :  RequestListener<Drawable> {
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


}