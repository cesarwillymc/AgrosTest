package com.cesarwillymc.agrostest.presentation.main.ui.dashboard.di

import androidx.annotation.VisibleForTesting
import com.cesarwillymc.agrostest.module.scope.FeatureScope
import com.cesarwillymc.agrostest.presentation.main.ui.dashboard.DashboardFragment
import com.cesarwillymc.agrostest.presentation.main.ui.dashboard.DashboardViewModel
import com.cesarwillymc.agrostest.common.viewModel
import com.cesarwillymc.agrostest.data.repo.ImageRepo
import dagger.Module
import dagger.Provides

@Module
class DashboardModule(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val fragment: DashboardFragment
) {

    @FeatureScope
    @Provides
    fun setupFragmentWithViewModel(
        imageRepo: ImageRepo
    ) = fragment.viewModel {
        DashboardViewModel(imageRepo)
    }

}