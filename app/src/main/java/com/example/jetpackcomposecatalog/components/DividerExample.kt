package com.example.jetpackcomposecatalog.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun MyDividerPreview() {
    MyCustomDivider()
}


@Composable
fun MyCustomDivider() {
    Column {
        Text("Foo")
        Divider(modifier = Modifier.fillMaxWidth().padding(16.dp), thickness = 1.dp, color = Color.Black)
        Text("Bar")
    }
}