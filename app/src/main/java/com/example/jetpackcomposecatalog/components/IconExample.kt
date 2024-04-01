package com.example.jetpackcomposecatalog.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

/**
 * Material Design
 * https://fonts.google.com/icons?icon.query=star
 * implementation 'androix.compose.material:material-icons-extended'
 */
@Preview(showBackground = true)
@Composable
fun MyIcon() { // parte de material design
    Icon(
        imageVector = Icons.Rounded.Check, contentDescription = "Icon",
        modifier = Modifier.clip(
            CircleShape
        ),
        tint = Color.Cyan,
    )
}