package com.example.jetpackcomposecatalog.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme

@Preview(showBackground = true)
@Composable
fun PreviewDropdown() {
    JetpackComposeCatalogTheme {
        DropdownGoogle()
    }
}
@Composable
fun DropdownGoogle(){
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopStart)
    ) {
        IconButton(onClick = { expanded = true }) {
            Icon(Icons.Default.MoreVert, contentDescription = "Localized description")
        }

        Spacer(modifier = Modifier.padding(100.dp))
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            DropdownMenuItem(
                text = { Text("Edit") },
                onClick = { /* Handle edit! */ },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = null
                    )
                })
            DropdownMenuItem(
                text = { Text("Settings") },
                onClick = { /* Handle settings! */ },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Settings,
                        contentDescription = null
                    )
                })
            Divider()
            DropdownMenuItem(
                text = { Text("Send Feedback") },
                onClick = { /* Handle send feedback! */ },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Email,
                        contentDescription = null
                    )
                },
                trailingIcon = { Text("F11", textAlign = TextAlign.Center) })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDown() {

    var selectedText by remember {
        mutableStateOf("")
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    val planets = listOf<String>("Mercurio", "Venus", "Marte", "Tierra", "Jupiter")

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText, onValueChange = { selectedText = it },
            readOnly = true, enabled = false,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp),
            offset = DpOffset(5.dp, 5.dp)
        ) {
            planets.forEach { planet ->
                DropdownMenuItem(text = { Text(text = planet) }, onClick = {
                    expanded = false
                    selectedText = planet
                }, modifier = Modifier.padding(0.dp, 0.dp))
            }
        }
    }

}