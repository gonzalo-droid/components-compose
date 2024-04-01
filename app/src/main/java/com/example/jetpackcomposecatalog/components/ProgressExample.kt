package com.example.jetpackcomposecatalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalog.components.MySpacer

@Preview(showBackground = true)
@Composable
fun MyProgressAdvance() {

    var progressStatus by rememberSaveable {
        mutableStateOf(0f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CircularProgressIndicator(progress = progressStatus)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Button(onClick = { progressStatus -= 0.1f }) {
                Text(text = "-")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = { progressStatus += 0.1f }) {
                Text(text = "+")
            }
        }

    }
}


@Composable
fun MyProgressBar() {

    var shoLoading by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (shoLoading) {
            CircularProgressIndicator(color = Color.Magenta, strokeWidth = 3.dp)
            MySpacer(size = 20)
            LinearProgressIndicator(
                modifier = Modifier.padding(26.dp), color = Color.Red, trackColor = Color.Blue
            )
        }

        Button(onClick = { shoLoading = !shoLoading }) {
            Text(text = "Click")
        }

    }
}