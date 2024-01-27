package com.example.shift.data

import com.example.shift.domain.model.Results
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/api")
    suspend fun getUsers(
        @Query("results") results: Int = 20
    ): Results
}