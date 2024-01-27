package com.example.shift.data

import com.example.shift.domain.UserRepository
import com.example.shift.domain.model.UserEntity


class UserRepositoryImpl: UserRepository {
    override suspend fun getUsers(): List<UserEntity> {
        val results = ApiClient.apiService.getUsers()
        return results.results
    }
}