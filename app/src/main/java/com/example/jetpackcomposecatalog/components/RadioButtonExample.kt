package com.example.jetpackcomposecatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun MyRadioButtonListPreview() {
    var selected by remember {
        mutableStateOf("Aris")
    }
    Column(modifier = Modifier.fillMaxSize()) {
        MyRadioButtonList(name = selected, onItemSelected = { selected = it }

        )
    }
}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {

    Column(Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(selected = name == "Mars", onClick = { onItemSelected("Mars") })

            Text(text = "Mars")
        }
        Row(
            modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(selected = name == "Earth", onClick = { onItemSelected("Earth") })

            Text(text = "Earth")
        }
        Row(
            modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(selected = name == "Jupiter", onClick = { onItemSelected("Jupiter") })

            Text(text = "Jupiter")
        }
        Row(
            modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(selected = name == "Uranus", onClick = { onItemSelected("Uranus") })

            Text(text = "Uranus")
        }
    }
}


@Composable
fun MyRadioButton() {
    Row(
        modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = false, onClick = { /*TODO*/ }, colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Blue,
                disabledSelectedColor = Color.Yellow,
                disabledUnselectedColor = Color.Green

            )
        )
        Text(text = "Select your planet")
    }
}

