package com.example.jetpackcomposecatalog.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun SliderPreview() {
    MyRangeSlider()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider() {
    var currentRange by remember {
        mutableStateOf(0f..10f)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(
            start = 0.dp, top = 20.dp, end = 0.dp, bottom = 0.dp

        )
    ) {
        RangeSlider(
            value = currentRange,
            onValueChange = { currentRange = it },
            // modifier =,
            // enabled = false,
            valueRange = 0f..10f,
            steps = 9,
            // onValueChangeFinished = {},
            // colors =
        )
        Text(text = "Valur down ${currentRange.start}")
        Text(text = "Valur up ${currentRange.endInclusive}")

    }
}

@Composable
fun AdvanceSlider() {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }

    // Se llama cuando el slider se detiene
    var completeValue by remember {
        mutableStateOf("Value 0f")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(
            start = 0.dp, top = 20.dp, end = 0.dp, bottom = 0.dp

        )
    ) {
        Text(text = completeValue.toString())
        Slider(
            modifier = Modifier.semantics { contentDescription = "Localized Description" },
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = {
                completeValue = "Value ${sliderPosition.toString()}"
            },
            colors = SliderDefaults.colors(),
            enabled = true,
            valueRange = 0f..10f,
            steps = 5,


            )
    }
}


@Composable
fun BasicSlider() {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = sliderPosition.toString())
        Slider(
            modifier = Modifier.semantics { contentDescription = "Localized Description" },
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            colors = SliderDefaults.colors(),
            enabled = true,
        )
    }
}