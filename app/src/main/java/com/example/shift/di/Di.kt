package com.example.shift.di

import com.example.shift.data.UserRepositoryImpl
import com.example.shift.data.db.AppDatabase
import com.example.shift.data.db.UserDao
import com.example.shift.domain.UserRepository
import com.example.shift.domain.UserUseCase
import com.example.shift.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val module = module {
    single<UserDao> {
        AppDatabase.getInstance(context = get()).userDao()
    }
    single<UserRepository> {
        UserRepositoryImpl()
    }
    factory<UserUseCase> {
        UserUseCase(get(), get())
    }
    viewModel<MainViewModel> {
        MainViewModel(get())
    }

}