package com.cesarwillymc.agrostest.module.module

import android.content.Context
import androidx.room.Room
import com.cesarwillymc.agrostest.core.db.ImagesDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideImagesDatabase(context: Context) =
        Room.databaseBuilder(context, ImagesDB::class.java, "AppDB")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideImagesDao(appdb: ImagesDB) =
        appdb.imageListData()
}
