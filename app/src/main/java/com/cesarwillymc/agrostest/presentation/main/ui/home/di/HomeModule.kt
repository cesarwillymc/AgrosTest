package com.cesarwillymc.agrostest.presentation.main.ui.home.di

import androidx.annotation.VisibleForTesting
import com.cesarwillymc.agrostest.module.scope.FeatureScope
import com.cesarwillymc.agrostest.presentation.main.ui.home.HomeFragment
import com.cesarwillymc.agrostest.common.viewModel
import com.cesarwillymc.agrostest.data.repo.ImageRepo
import com.cesarwillymc.agrostest.presentation.main.ui.home.HomeViewModel
import dagger.Module
import dagger.Provides

@Module
class HomeModule(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val fragment: HomeFragment
) {

    @FeatureScope
    @Provides
    fun setupFragmentWithViewModel(
        imageRepo:ImageRepo
    ) = fragment.viewModel {
        HomeViewModel(imageRepo)
    }
}