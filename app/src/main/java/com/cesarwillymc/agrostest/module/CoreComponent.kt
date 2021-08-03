package com.cesarwillymc.agrostest.module

import android.content.Context
import com.cesarwillymc.agrostest.module.module.ContextModule
import com.cesarwillymc.agrostest.module.module.DatabaseModule
import com.cesarwillymc.agrostest.module.module.NetworkModule
import com.cesarwillymc.agrostest.module.module.RepositoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        RepositoryModule::class
    ]
)
interface CoreComponent {
    fun context(): Context
}