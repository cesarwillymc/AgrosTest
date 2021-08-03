package com.cesarwillymc.agrostest.presentation.main.ui.home.di

import com.cesarwillymc.agrostest.module.CoreComponent
import com.cesarwillymc.agrostest.module.scope.FeatureScope
import com.cesarwillymc.agrostest.presentation.main.ui.home.HomeFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [HomeModule::class],
    dependencies = [CoreComponent::class]
)
interface HomeComponent {
    fun inject(fragment:HomeFragment)
}