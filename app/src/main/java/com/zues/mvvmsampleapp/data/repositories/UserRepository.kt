package com.zues.mvvmsampleapp.data.repositories

import com.zues.mvvmsampleapp.data.db.AppDatabase
import com.zues.mvvmsampleapp.data.db.entities.User
import com.zues.mvvmsampleapp.data.network.MyApi
import com.zues.mvvmsampleapp.data.network.SafeApiRequest
import com.zues.mvvmsampleapp.data.network.responses.AuthResponse

/* ---  Created by akhtarz on 12/4/2019. ---*/
class UserRepository(private val myApi: MyApi, private val db: AppDatabase) :
    SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest {
            myApi.userLogin(email, password)
        }
    }

    suspend fun userSignUp(name: String, email: String, password: String): AuthResponse {
        return apiRequest {
            myApi.userSignup(name, email, password)
        }
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getUser()

}