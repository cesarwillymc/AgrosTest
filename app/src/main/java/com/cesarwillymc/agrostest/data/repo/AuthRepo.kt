package com.cesarwillymc.agrostest.data.repo

import com.cesarwillymc.agrostest.core.model.Usuario

interface AuthRepo {
    suspend fun signIn(user:String,password:String): Usuario
}