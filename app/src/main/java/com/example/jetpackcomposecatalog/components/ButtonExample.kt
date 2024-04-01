package com.example.jetpackcomposecatalog

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MyButtonExample() {
    var status by rememberSaveable {
        mutableStateOf(true)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = {
                Log.d("DameClick", "Log")
            }, modifier = Modifier.padding(10.dp), colors = ButtonDefaults.buttonColors(
                contentColor = Color.Cyan,
                containerColor = Color.Magenta,
            ), border = BorderStroke(
                2.dp, Color.DarkGray
            ), enabled = status

        ) {
            Text(text = "Dame Click")
        }

        OutlinedButton(
            onClick = { Log.d("DameClick", "Log") },
            modifier = Modifier.padding(10.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Cyan,
                containerColor = Color.Magenta,
                disabledContainerColor = Color.Blue,
                disabledContentColor = Color.Red,
            ),
            enabled = status
        ) {
            Text(text = "Dame Click")
        }

        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Dame click")
        }
    }
}


