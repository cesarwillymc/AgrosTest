package com.cesarwillymc.agrostest.core.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.cesarwillymc.agrostest.core.model.Image
@Dao
interface ImagesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertImage(item: Image)

    @Query("DELETE FROM imagedao where id == :image")
    fun deleteImage(image:String)

    @Query("SELECT * FROM imagedao ORDER  by date desc limit 6 ")
    fun getAllImages(): LiveData<List<Image>>
}