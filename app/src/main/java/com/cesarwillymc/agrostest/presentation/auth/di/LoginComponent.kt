package com.cesarwillymc.agrostest.presentation.auth.di

import com.cesarwillymc.agrostest.module.CoreComponent
import com.cesarwillymc.agrostest.module.scope.FeatureScope
import com.cesarwillymc.agrostest.presentation.auth.AuthActivity
import dagger.Component

@FeatureScope
@Component(
    modules = [LoginModule::class],
    dependencies = [CoreComponent::class]
)
interface LoginComponent {
    fun inject(activity:AuthActivity)
}