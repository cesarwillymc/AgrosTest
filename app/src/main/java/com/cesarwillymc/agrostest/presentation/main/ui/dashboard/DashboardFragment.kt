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
import androidx.recyclerview.widget.GridLayoutManager
import com.cesarwillymc.agrostest.presentation.main.ui.dashboard.common.MySizeLookup


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

        viewModel.listImage.observe(viewLifecycleOwner) {
            inicializarRV(it.size)
            imageAdapter.updateData(it)

        }

    }

    private fun inicializarRV(size: Int) {
        imageAdapter = ImageDashboarddapter()
        val manager = GridLayoutManager(context, 2)
        manager.spanSizeLookup = MySizeLookup(size =size )
        viewBinding.rvListImages.apply {
            layoutManager = manager
            adapter = imageAdapter
        }
    }


}