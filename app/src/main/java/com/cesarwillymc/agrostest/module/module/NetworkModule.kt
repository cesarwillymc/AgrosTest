package com.cesarwillymc.agrostest.module.module


import com.cesarwillymc.agrostest.data.utils.RequestUser
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRequestUser( ): RequestUser = RequestUser()
}