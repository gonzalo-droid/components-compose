package com.example.jetpackcomposecatalog.loginScreen.data.repository

import com.example.jetpackcomposecatalog.loginScreen.data.network.LoginService

class LoginRepository {
    private val api = LoginService()

    suspend fun doLogin(user: String, password: String) :Boolean{
        return api.doLogin(user, password)
    }
}