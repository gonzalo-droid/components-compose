package com.example.jetpackcomposecatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyComplexLayout() {
    Column(
        Modifier.fillMaxSize()
    ) {

        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .weight(1f),
            contentAlignment = Alignment.Center

        ) {
            Text(text = "Welcome to the jungle")
        }

        MySpacer(size = 30)

        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(10.dp)
        ) {
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red),

                contentAlignment = Alignment.CenterStart
            ) {
                Text(text = "RED")
            }

            Spacer(modifier = Modifier.width(10.dp))

            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(text = "Green")
            }

        }

        MySpacer(size = 80)

        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Magenta)
                .weight(1f),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Green")
        }
    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyRow() {
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(
                rememberScrollState()
            ), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Example 100", modifier = Modifier
                .width(150.dp)
                .padding(2.dp)
        )
        Text(
            text = "Example 200", modifier = Modifier
                .width(150.dp)
                .padding(2.dp)
        )
        Text(
            text = "Example 300", modifier = Modifier
                .width(150.dp)
                .padding(2.dp)
        )
        Text(
            text = "Example 400", modifier = Modifier
                .width(150.dp)
                .padding(2.dp)
        )
        Text(
            text = "Example 500", modifier = Modifier
                .width(150.dp)
                .padding(2.dp)
        )
        Text(
            text = "Example 600", modifier = Modifier
                .width(150.dp)
                .padding(2.dp)
        )
    }
}

@Composable
fun MyColumn() {
    Column(
        Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Example 100",
            modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(50.dp)
        )

        Text(
            text = "Example 200",
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(50.dp)
        )

        Text(
            text = "Example 200",
            modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(50.dp)
        )
    }
}

@Composable
fun MyBox() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Cyan)
                .verticalScroll(
                    rememberScrollState()
                ), contentAlignment = Alignment.BottomCenter
        ) {
            Text("This is text in my world")
        }
    }
}