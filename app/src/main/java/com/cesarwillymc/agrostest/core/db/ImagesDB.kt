package com.cesarwillymc.agrostest.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cesarwillymc.agrostest.core.db.dao.ImagesDao
import com.cesarwillymc.agrostest.core.model.Image

@Database(entities = [Image::class],
    exportSchema = false,
    version = 1,)

abstract class ImagesDB : RoomDatabase() {

    abstract fun imageListData(): ImagesDao

}