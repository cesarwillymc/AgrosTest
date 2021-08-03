package com.cesarwillymc.agrostest.core.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "imagedao")
data class Image(
    @PrimaryKey(autoGenerate = false)
    val id: String
)