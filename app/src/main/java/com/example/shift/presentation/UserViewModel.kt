package com.example.shift.presentation

import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() /*(application: Application) : AndroidViewModel(application)*/ {
////    private val pizzaDao = PizzaDatabase.getDatabase(application).pizzaDao()
//    val usersUseCase = UserUseCase(UserRepositoryImpl()/*, pizzaDao*/)
//    private val _users = MutableLiveData<List<UserEntity>>()
//    val users: LiveData<List<UserEntity>> get() = _users
//    private val _errorLiveData = MutableLiveData<String>()
//    val errorLiveData: LiveData<String> get() = _errorLiveData
//    init {
//        getUsers()
//    }
//    private fun getUsers() {
//        viewModelScope.launch {
//            try {
//                _users.value = usersUseCase.getUsers()
//            } catch (e: Exception) {
//                _errorLiveData.value = "Не известная ошибка"
//            }
//        }
//    }
}