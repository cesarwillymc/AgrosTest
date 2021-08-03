package com.cesarwillymc.agrostest.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cesarwillymc.movie.core.db.dao.MovieDao
import com.cesarwillymc.movie.core.model.Movie

@Database(entities = [Movie::class],
    exportSchema = false,
    version = 1,)

abstract class ImagesDB : RoomDatabase() {

    abstract fun moviesListData(): MovieDao

}