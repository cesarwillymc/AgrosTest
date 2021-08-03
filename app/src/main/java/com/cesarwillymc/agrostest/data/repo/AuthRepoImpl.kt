package com.cesarwillymc.agrostest.data.repo

import com.cesarwillymc.agrostest.core.model.Usuario
import com.cesarwillymc.agrostest.data.utils.RequestUser
import kotlinx.coroutines.delay

class AuthRepoImpl(private val request: RequestUser):AuthRepo {

    override suspend fun signIn(user: String, password: String): Usuario {
        delay(1000L)
        return request.requestServer(user, password)
    }

}