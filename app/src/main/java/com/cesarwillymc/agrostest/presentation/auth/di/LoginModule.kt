package com.cesarwillymc.agrostest.presentation.auth.di

import androidx.annotation.VisibleForTesting
import com.cesarwillymc.agrostest.common.viewModel
import com.cesarwillymc.agrostest.data.repo.AuthRepo
import com.cesarwillymc.agrostest.module.scope.FeatureScope
import com.cesarwillymc.agrostest.presentation.auth.AuthActivity
import com.cesarwillymc.agrostest.presentation.auth.AuthViewModel
import dagger.Module
import dagger.Provides

@Module
class LoginModule(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val activity: AuthActivity
) {

    @FeatureScope
    @Provides
    fun setupFragmentWithViewModel(
        repo: AuthRepo
    ) = activity.viewModel {
        AuthViewModel(repo = repo)
    }
}