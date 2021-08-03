package com.cesarwillymc.agrostest.core.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cesarwillymc.agrostest.core.model.Image
@Dao
interface ImagesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertImage(item: Image)

    @Query("SELECT * FROM imagedao limit 6")
    fun getAllImages(): LiveData<List<Image>>
}