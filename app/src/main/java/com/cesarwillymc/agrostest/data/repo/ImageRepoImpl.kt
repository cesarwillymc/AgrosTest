package com.cesarwillymc.agrostest.data.repo

import androidx.lifecycle.LiveData
import com.cesarwillymc.agrostest.core.db.dao.ImagesDao
import com.cesarwillymc.agrostest.core.model.Image

class ImageRepoImpl(private val imageDao: ImagesDao) : ImageRepo {

    override  fun getImageDB(): LiveData<List<Image>> {
        return imageDao.getAllImages()
    }

    override fun insertImageDB(image: Image) {
        imageDao.insertImage(image)
    }

    override fun deleteImageDB(image: Image) {
        imageDao.deleteImage(image.id)
    }

}