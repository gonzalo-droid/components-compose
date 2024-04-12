package com.example.jetpackcomposecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposecatalog.loginScreen.LoginScreen
import com.example.jetpackcomposecatalog.loginScreen.LoginViewModel
import com.example.jetpackcomposecatalog.navigation.Routes.*
import com.example.jetpackcomposecatalog.navigation.Screen1
import com.example.jetpackcomposecatalog.navigation.Screen2
import com.example.jetpackcomposecatalog.navigation.Screen3
import com.example.jetpackcomposecatalog.navigation.Screen4
import com.example.jetpackcomposecatalog.navigation.Screen5
import com.example.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    
                    // Login Screen
                    
                    LoginScreen(viewModel = LoginViewModel())
                    

                    // COMPONENTS
                    /*
                    Column(modifier = Modifier.fillMaxSize()) {
                        MonaRecyclerView()
                    }
                     */

                    // NAVIGATION
                    /*
                    val navigationController = rememberNavController()

                    NavHost(
                        navController = navigationController,
                        startDestination = RouteScreen1.route
                    ) {
                        composable(route = RouteScreen1.route) {
                            Screen1(navigationController)
                        }
                        composable(route = RouteScreen2.route) {
                            Screen2(navigationController)
                        }
                        composable(route = RouteScreen3.route) {
                            Screen3(navigationController)
                        }
                        composable(route = RouteScreen4.route, arguments = listOf(
                            navArgument("age") { type = NavType.IntType }
                        )) { backStackEntry ->
                            Screen4(
                                navigationController,
                                backStackEntry.arguments?.getInt("age") ?: 0
                            )
                        }

                        composable(route = RouteScreen5.route, arguments = listOf(
                            navArgument("name") { defaultValue = "No user" }
                        )) { backStackEntry ->
                            Screen5(
                                navigationController,
                                backStackEntry.arguments?.getString("name")
                            )
                        }

                    }
                     */

                }
            }
        }
    }
}





