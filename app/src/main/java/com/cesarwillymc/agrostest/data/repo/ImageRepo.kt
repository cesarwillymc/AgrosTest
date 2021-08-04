package com.cesarwillymc.agrostest.data.repo

import androidx.lifecycle.LiveData
import com.cesarwillymc.agrostest.core.model.Image


interface ImageRepo {
    fun getImageDB(): LiveData<List<Image>>
    fun getImageDBLimit(): LiveData<List<Image>>
    fun insertImageDB(image: Image)
    fun deleteImageDB(image: Image)
}