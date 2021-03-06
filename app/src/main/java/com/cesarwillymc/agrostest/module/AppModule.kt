
package com.cesarwillymc.agrostest.module

import android.content.Context
import com.cesarwillymc.agrostest.app.MyApp
import dagger.Module
import dagger.Provides


@Module
class AppModule {


    @Provides
    fun provideContext(application: MyApp): Context = application.applicationContext
}
