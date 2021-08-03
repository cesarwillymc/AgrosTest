package com.cesarwillymc.agrostest.presentation.main.ui.home


import com.cesarwillymc.agrostest.R
import com.cesarwillymc.agrostest.app.MyApp
import com.cesarwillymc.agrostest.base.BaseFragment
import com.cesarwillymc.agrostest.databinding.FragmentHomeBinding
import com.cesarwillymc.agrostest.presentation.main.ui.home.di.DaggerHomeComponent
import com.cesarwillymc.agrostest.presentation.main.ui.home.di.HomeModule


class HomeFragment : BaseFragment<FragmentHomeBinding,HomeViewModel>(R.layout.fragment_home) {
    override fun onInitDependencyInjection() {
        DaggerHomeComponent.builder().coreComponent(MyApp.coreComponent(requireContext()))
            .homeModule(HomeModule(this)).build().inject(this)
    }

    override fun onInitDataBinding() {
       viewBinding.viewModel =  viewModel
    }


}