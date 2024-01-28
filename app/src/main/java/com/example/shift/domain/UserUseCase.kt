package com.example.shift.domain

import com.example.shift.data.db.UserDao
import com.example.shift.domain.model.UserEntity


class UserUseCase (private val userRepository: UserRepository, private val userDao: UserDao) {

    suspend fun getUsers(): List<UserEntity> {
        val users = userDao.getAllUsers()
        return users.ifEmpty {
            val usersRepository = userRepository.getUsers()
            userDao.insertUsers(*usersRepository.toTypedArray())
            usersRepository
        }
    }
    suspend fun getRefreshUsers(): List<UserEntity> {
        userDao.clearAllUsers()
        val usersRepository = userRepository.getUsers()
        userDao.insertUsers(*usersRepository.toTypedArray())
        return usersRepository
    }
}