package com.example.daggerhilttest.retrofit

import retrofit2.http.GET

interface UserService {
    @GET("users")
    suspend fun getUsers():List<User>

}