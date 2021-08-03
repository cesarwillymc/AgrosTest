package com.cesarwillymc.agrostest.presentation.main.ui.dashboard


import com.cesarwillymc.agrostest.R
import com.cesarwillymc.agrostest.app.MyApp
import com.cesarwillymc.agrostest.base.BaseFragment
import com.cesarwillymc.agrostest.databinding.FragmentDashboardBinding
import com.cesarwillymc.agrostest.presentation.main.ui.dashboard.di.DaggerDashboardComponent
import com.cesarwillymc.agrostest.presentation.main.ui.dashboard.di.DashboardModule

class DashboardFragment : BaseFragment<FragmentDashboardBinding,DashboardViewModel>(R.layout.fragment_dashboard) {


    override fun onInitDependencyInjection() {
        DaggerDashboardComponent.builder().coreComponent(MyApp.coreComponent(requireContext()))
            .dashboardModule(DashboardModule(this)).build().inject(this)
    }

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
    }


}