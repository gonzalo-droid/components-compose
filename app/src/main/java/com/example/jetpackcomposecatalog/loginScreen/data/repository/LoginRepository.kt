package com.example.jetpackcomposecatalog.loginScreen.data.repository

import com.example.jetpackcomposecatalog.loginScreen.data.network.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: LoginService) {
    //private val api = LoginService()

    suspend fun doLogin(user: String, password: String) :Boolean{
        return api.doLogin(user, password)
    }
}