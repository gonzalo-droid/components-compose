package com.example.jetpackcomposecatalog.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


@Preview(showBackground = true)
@Composable
fun CustomConfirmationAlertDialogPreview() {

    var isShow by remember { mutableStateOf(false) }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { isShow = true }) {
            Text(text = "Select option")
        }
        CustomConfirmationAlertDialog(
            isShow = isShow,
            onDismiss = { isShow = false },
            onConfirm = { Log.i("GonDev", "click Dialog") })
    }
}


@Composable
fun CustomConfirmationAlertDialog(isShow: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {

    if (isShow) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = true, // click back dismiss dialog
                dismissOnClickOutside = true // click outSide
            ),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(
                        color = Color.White, // Color del fondo del borde
                        shape = RoundedCornerShape(8.dp) // Radio de las esquinas
                    )
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                ) {
                    MyTitle(text = "Phone ringtone", modifier = Modifier.padding(24.dp))
                    HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray)
                    var status by remember {
                        mutableStateOf("Jupiter")
                    }
                    MyRadioButtonList(status) {
                        status = it
                    }

                    HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray)

                    Row(
                        modifier = Modifier
                            .align(alignment = Alignment.End)
                            .padding(8.dp)
                    ) {
                        TextButton(onClick = { onDismiss() }) {
                            Text(text = "Cancel")
                        }

                        TextButton(onClick = { onDismiss() }) {
                            Text(text = "Accept")
                        }
                    }
                }
            }
        }
    }

}

