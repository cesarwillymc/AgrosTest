package com.cesarwillymc.agrostest.presentation.main.ui.dashboard


import android.os.Bundle
import android.view.View
import com.cesarwillymc.agrostest.R
import com.cesarwillymc.agrostest.app.MyApp
import com.cesarwillymc.agrostest.base.BaseFragment
import com.cesarwillymc.agrostest.databinding.FragmentDashboardBinding
import com.cesarwillymc.agrostest.presentation.main.ui.dashboard.adapter.ImageDashboarddapter
import com.cesarwillymc.agrostest.presentation.main.ui.dashboard.di.DaggerDashboardComponent
import com.cesarwillymc.agrostest.presentation.main.ui.dashboard.di.DashboardModule
import com.google.android.flexbox.*


class DashboardFragment : BaseFragment<FragmentDashboardBinding,DashboardViewModel>(R.layout.fragment_dashboard) {


    override fun onInitDependencyInjection() {
        DaggerDashboardComponent.builder().coreComponent(MyApp.coreComponent(requireContext()))
            .dashboardModule(DashboardModule(this)).build().inject(this)
    }

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
    }
    private lateinit var imageAdapter: ImageDashboarddapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inicializarRV()
        viewModel.listImage.observe(viewLifecycleOwner) {
            imageAdapter.updateData(it)
        }

    }

    private fun inicializarRV() {
        imageAdapter = ImageDashboarddapter(requireActivity())

        val manager = FlexboxLayoutManager(context).apply {
            flexDirection = FlexDirection.ROW
            alignItems = AlignItems.CENTER
        }


        viewBinding.rvListImages.apply {
            layoutManager = manager
            adapter = imageAdapter
        }
    }


}