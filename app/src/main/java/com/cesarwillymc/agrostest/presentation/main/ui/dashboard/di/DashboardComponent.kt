package com.cesarwillymc.agrostest.presentation.main.ui.dashboard.di

import com.cesarwillymc.agrostest.module.CoreComponent
import com.cesarwillymc.agrostest.module.scope.FeatureScope
import com.cesarwillymc.agrostest.presentation.main.ui.dashboard.DashboardFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [DashboardModule::class],
    dependencies = [CoreComponent::class]
)
interface DashboardComponent {
    fun inject(fragment:DashboardFragment)
}