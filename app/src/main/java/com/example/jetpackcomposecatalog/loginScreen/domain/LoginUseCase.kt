package com.example.jetpackcomposecatalog.loginScreen.domain

import com.example.jetpackcomposecatalog.loginScreen.data.repository.LoginRepository

class LoginUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogin(user, password)
    }
}