package com.example.jetpackcomposecatalog.componentsAndroid

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldComponent() {

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        topBar = {
            TopAppBarSample {
                scope.launch {
                    snackbarHostState.showSnackbar("onClick $it")
                }
            }
        },
        bottomBar = { MyBottomNavigationCustom() },
        floatingActionButton = { FloatingActionButtonExample() },
        floatingActionButtonPosition = FabPosition.End,
    ) {
        Box(
            Modifier
                .height(50.dp)
                .fillMaxWidth()
                .background(Color.Red)
        ) {
        }
    }
}

@Composable
fun MyBottomNavigationCustom() {
    var index by remember {
        mutableStateOf(0)
    }
    NavigationBar(contentColor = Color.White, containerColor = Color.Gray, tonalElevation = 20.dp) {
        NavigationBarItem(selected = index == 0, onClick = { index = 0 }, icon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = ""
            )
        }, label = { Text(text = "Search") })
        NavigationBarItem(selected = index == 1, onClick = { index = 1 }, icon = {
            Icon(
                imageVector = Icons.Default.Image,
                contentDescription = ""
            )
        }, label = { Text(text = "Image") })
        NavigationBarItem(selected = index == 2, onClick = { index = 2 }, icon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = ""
            )
        }, label = { Text(text = "Home") })

    }
}

@Composable
fun FloatingActionButtonExample() {
    FloatingActionButton(
        onClick = { print("Hello") },
        contentColor = Color.White,
        containerColor = Color.Black,
        shape = FloatingActionButtonDefaults.extendedFabShape
    ) {
        Icon(Icons.Filled.Favorite, "Floating action button.")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSample(onClick: (String) -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Gray,
            titleContentColor = Color.White,
            actionIconContentColor = Color.Red,
            navigationIconContentColor = Color.Green,
        ),
        navigationIcon = {
            IconButton(onClick = {
                onClick("Menu")
            }) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
            }
        },
        title = { Text(text = "Sample Title") },
        actions = {
            IconButton(onClick = { onClick("Search") }) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null
                )
            }
            IconButton(onClick = { onClick("AccountCircle") }) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = null
                )
            }
        }
    )
}

