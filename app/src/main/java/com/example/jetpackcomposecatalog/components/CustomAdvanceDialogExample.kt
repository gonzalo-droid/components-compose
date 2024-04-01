package com.example.jetpackcomposecatalog.components

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.jetpackcomposecatalog.R


@Preview(showBackground = true)
@Composable
fun CustomAdvanceAlertDialogPreview() {

    var isShow by remember { mutableStateOf(false) }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { isShow = true }) {
            Text(text = "Google accounts")
        }
        CustomAdvanceAlertDialog(
            isShow = isShow,
            onDismiss = { isShow = false },
            onConfirm = { Log.i("GonDev", "click Dialog") })
    }
}


@Composable
fun CustomAdvanceAlertDialog(isShow: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {

    if (isShow) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = true, // click back dismiss dialog
                dismissOnClickOutside = true // click outSide
            ),
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitle(text = "Set backup account")
                AccountItem(email = "mona@gmail.com", drawable = R.drawable.mona_profile)
                AccountItem(email = "mona@gmail.com", drawable = R.drawable.mona_profile)
                AccountItem(email = "mona@gmail.com", drawable = R.drawable.mona_profile)
            }
        }
    }

}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )

        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun MyTitle(text: String, modifier: Modifier = Modifier.padding(bottom = 12.dp)) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}