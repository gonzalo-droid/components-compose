package com.example.jetpackcomposecatalog.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Navigation() {
}


@Composable
fun Screen1(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(

            text = "Screen",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Center)
                .background(Color.Black, shape = RoundedCornerShape(10.dp))
                .padding(16.dp)
                .clickable {
                    navigationController.navigate(Routes.RouteScreen2.route)
                })
    }
}

@Composable
fun Screen2(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(
            text = "Screen",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Center)
                .background(Color.Black, shape = RoundedCornerShape(10.dp))
                .padding(16.dp)
                .clickable {
                    navigationController.navigate(Routes.RouteScreen3.route)
                })
    }
}

@Composable
fun Screen3(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = "Screen",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Center)
                .background(Color.Black, shape = RoundedCornerShape(10.dp))
                .padding(16.dp)
                .clickable {
                    navigationController.navigate(Routes.RouteScreen4.createRoute(123321))
                })
    }
}

@Composable
fun Screen4(navigationController: NavHostController, age: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Text(
            text = "I'm $age years old",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Center)
                .background(Color.Black, shape = RoundedCornerShape(10.dp))
                .padding(16.dp)
                .clickable {
                    navigationController.navigate(Routes.RouteScreen5.createRoute("AristDev"))
                })
    }
}

@Composable
fun Screen5(navigationController: NavHostController, name: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(
            text = "Hi, $name",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Center)
                .background(Color.Black, shape = RoundedCornerShape(10.dp))
                .padding(16.dp)
                .clickable {
                    //navigationController.navigate(Routes.RouteScreen1.route)
                })
    }
}