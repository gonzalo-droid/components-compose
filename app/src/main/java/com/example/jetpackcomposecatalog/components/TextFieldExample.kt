package com.example.jetpackcomposecatalog

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme



@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldOutlined() {
    var myText by remember {
        mutableStateOf("")
    }
    OutlinedTextField(value = myText, onValueChange = {
        myText = it
    }, label = {
        Text(text = "Introduce tu nombre")
    }, modifier = Modifier.padding(24.dp), colors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = Color.Magenta, unfocusedBorderColor = Color.Cyan
    )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldAdvance() {
    var myText by remember {
        mutableStateOf("")
    }
    TextField(value = myText, onValueChange = {
        myText = it
    }, label = {
        Text(text = "Introduce tu nombre")
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {

    var myTest by remember {
        mutableStateOf("")
    }

    TextField(value = myTest, onValueChange = {
        myTest = it
    })
}

@Composable
fun MyTextFieldAdmin() {
    var myText by remember {
        mutableStateOf("")
    }

    MyTextFieldLambda(name = myText, onValueChange = { myText = it })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldLambda(name: String, onValueChange: (String) -> Unit) {

    TextField(value = name, onValueChange = {
        onValueChange(it)
    })
}


