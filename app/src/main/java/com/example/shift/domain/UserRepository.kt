package com.example.shift.domain

import com.example.shift.domain.model.UserEntity

interface UserRepository {
    suspend fun getUsers(): List<UserEntity>
}