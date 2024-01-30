package com.example.shift.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shift.domain.UserUseCase
import com.example.shift.domain.model.UserEntity
import kotlinx.coroutines.launch

class MainViewModel (private val usersUseCase: UserUseCase) : ViewModel() {
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

    fun refreshUsers() {
        viewModelScope.launch {
            try {
                _users.value = usersUseCase.getRefreshUsers()
            } catch (e: Exception) {
                _errorLiveData.value = "Не известная ошибка"
            }
        }
    }
}