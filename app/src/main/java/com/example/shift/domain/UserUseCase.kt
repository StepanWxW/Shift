package com.example.shift.domain

import com.example.shift.domain.model.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class UserUseCase (private val userRepository: UserRepository) {

    suspend fun getUsers(): List<UserEntity> {
//        val isInternetAvailable = checkInternetAvailability()
//        return if (isInternetAvailable) {
            val users = userRepository.getUsers()
//            pizzaDao.clearAllPizzas()
//            pizzaDao.insertAllPizzas(pizzas)
            return users
//        } else {
//            pizzaDao.getAllPizzas()
//        }
    }
//    private suspend fun checkInternetAvailability(): Boolean {
//        return withContext(Dispatchers.IO) {
//            try {
//                val process = Runtime.getRuntime().exec("ping -c 1 google.com")
//                val exitValue = process.waitFor()
//                return@withContext (exitValue == 0)
//            } catch (e: IOException) {
//                return@withContext false
//            }
//        }
//    }
}