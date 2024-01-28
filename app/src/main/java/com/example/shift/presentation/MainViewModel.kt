package com.example.shift.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.shift.domain.UserUseCase
import com.example.shift.domain.model.UserEntity
import com.example.shift.data.UserRepositoryImpl
import com.example.shift.data.db.AppDatabase
import kotlinx.coroutines.launch

class MainViewModel (application: Application) : AndroidViewModel(application) {
    private val userDao = AppDatabase.getInstance(application).userDao()
    val usersUseCase = UserUseCase(UserRepositoryImpl(), userDao)
    private val _users = MutableLiveData<List<UserEntity>>()
    val users: LiveData<List<UserEntity>> get() = _users
    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData
    init {
        getUsers()
    }
    private fun getUsers() {
        viewModelScope.launch {
            try {
                _users.value = usersUseCase.getUsers()
            } catch (e: Exception) {
                _errorLiveData.value = "Не известная ошибка"
            }
        }
    }
}