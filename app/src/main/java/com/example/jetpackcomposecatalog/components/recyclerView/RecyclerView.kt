package com.example.jetpackcomposecatalog.components.recyclerView

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SimpleRecyclerView() {
    val myList = listOf("pepe", "manolo", "mars", "moon")
    LazyColumn {
        item { Text(text = "Items ") }
        items(4){
            Text(text = "Items $it")
        }
        items(myList) {
            Text(text = "Items $it")
        }
    }
}