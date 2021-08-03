package com.cesarwillymc.agrostest.app

import android.app.Application
import android.content.Context
import com.cesarwillymc.agrostest.module.CoreComponent
import com.cesarwillymc.agrostest.module.DaggerAppComponent
import com.cesarwillymc.agrostest.module.DaggerCoreComponent
import com.cesarwillymc.agrostest.module.module.ContextModule

class MyApp : Application() {
    lateinit var coreComponent: CoreComponent

    companion object {
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as? MyApp)?.coreComponent
    }

    override fun onCreate() {
        super.onCreate()
        initCoreDependencyInjection()
        initAppDependencyInjection()

    }

    private fun initCoreDependencyInjection() {
        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }

    private fun initAppDependencyInjection() {
        DaggerAppComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this)
    }

}