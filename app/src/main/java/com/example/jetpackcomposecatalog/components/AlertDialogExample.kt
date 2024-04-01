package com.example.jetpackcomposecatalog.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Preview(showBackground = true)
@Composable
fun MyAlertDialogPreview() {

    var isShow by remember { mutableStateOf(false) }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { isShow = true }) {
            Text(text = "Show dialog")
        }
        MyAlertDialog(
            isShow = isShow,
            onDismiss = { isShow = false },
            onConfirm = { Log.i("GonDev", "click Dialog") })
    }
}


@Composable
fun MyAlertDialog(isShow: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {

    if (isShow) {
        AlertDialog(

            onDismissRequest = { onDismiss() },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Dismiss")
                }
            },
            icon = {
                Icon(
                    Icons.Outlined.Edit,
                    contentDescription = null
                )
            },
            title = { Text(text = "Title") },
            text = { Text(text = "Hello, Saitama xd") },
        )
    }

}