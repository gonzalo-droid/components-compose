package com.example.jetpackcomposecatalog.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

data class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldComponent() {

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(16.dp))
                getItemsDrawer().forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = {
                            Text(text = item.title)
                        },
                        selected = index == selectedItemIndex,
                        onClick = {
//                                            navController.navigate(item.route)
                            selectedItemIndex = index
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedItemIndex) {
                                    item.selectedIcon
                                } else item.unselectedIcon,
                                contentDescription = item.title
                            )
                        },
                        badge = {
                            item.badgeCount?.let {
                                Text(text = item.badgeCount.toString())
                            }
                        },
                        modifier = Modifier
                            .padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        },
        drawerState = drawerState
    ) {

        Scaffold(
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },
            topBar = {
                TopAppBarSample(onClick =  {

                    scope.launch {
                       snackbarHostState.showSnackbar("OnClick $it")
                    }

                }, onClickDrawer =  {
                    scope.launch {
                        drawerState.open()
                    }
                })
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
}


fun getItemsDrawer(): List<NavigationItem> {
    return listOf(
        NavigationItem(
            title = "All",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
        ),
        NavigationItem(
            title = "Urgent",
            selectedIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info,
            badgeCount = 45
        ),
        NavigationItem(
            title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
        ),
    )

}

@Composable
fun MyDrawer() {
    // Material2
    Column(Modifier.padding(8.dp)) {
        Text(
            text = "Option 1", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Option 2", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Option 3", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Option 4", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
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
fun TopAppBarSample(onClick: (String) -> Unit, onClickDrawer:()->Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Gray,
            titleContentColor = Color.White,
            actionIconContentColor = Color.Red,
            navigationIconContentColor = Color.Green,
        ),
        navigationIcon = {
            IconButton(onClick = {
                onClickDrawer()
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

