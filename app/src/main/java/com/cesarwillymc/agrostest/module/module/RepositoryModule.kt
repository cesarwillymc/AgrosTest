package com.cesarwillymc.agrostest.module.module


import com.cesarwillymc.agrostest.core.db.dao.ImagesDao
import com.cesarwillymc.agrostest.data.repo.AuthRepo
import com.cesarwillymc.agrostest.data.repo.AuthRepoImpl
import com.cesarwillymc.agrostest.data.repo.ImageRepo
import com.cesarwillymc.agrostest.data.repo.ImageRepoImpl
import com.cesarwillymc.agrostest.data.utils.RequestUser
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideAuthRepo(request: RequestUser): AuthRepo = AuthRepoImpl(request)

    @Singleton
    @Provides
    fun provideImageRepo(imageDao: ImagesDao):  ImageRepo  = ImageRepoImpl(imageDao)


}