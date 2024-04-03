package com.example.jetpackcomposecatalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DoNotDisturbOnTotalSilence
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import org.w3c.dom.Text

@Preview(showBackground = true)
@Composable
fun TwitterScreen() {

    var favorite by remember {
        mutableStateOf(false)
    }

    var chat by remember {
        mutableStateOf(false)
    }

    var repeat by remember {
        mutableStateOf(false)
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF2A3D57))
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            LogoChild()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                HeaderCard(Modifier.fillMaxWidth())
                Text(
                    text = "b ansndnd naoisdnoian ansndnd naoisdnoian ansndnd naoisdnoian uansndnd naoisdnoiands naoisndoina buansndnd naoisdnoiands naoisndoina buansndnd naoisdnoiands naoisndoinads",
                    modifier = Modifier.padding(bottom = 16.dp), color = Color.White
                )

                Image(
                    painter = painterResource(id = R.drawable.mona_profile),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(10)),

                    )

                Row(
                    Modifier.padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    SocialIcon(
                        modifier = Modifier.weight(1f),
                        unSelectedIcon = {
                            Icon(
                                imageVector = Icons.Filled.FavoriteBorder,
                                contentDescription = "",
                                tint = Color.Gray
                            )
                        },
                        selectedIcon = {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "",
                                tint = Color.Gray
                            )
                        },
                        isSelected = favorite
                    ) {
                        favorite = !favorite
                    }

                    SocialIcon(
                        modifier = Modifier.weight(1f),
                        unSelectedIcon = {
                            Icon(
                                imageVector = Icons.Filled.FavoriteBorder,
                                contentDescription = "",
                                tint = Color.Gray
                            )
                        },
                        selectedIcon = {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "",
                                tint = Color.Gray
                            )
                        },
                        isSelected = chat
                    ) {
                        chat = !chat
                    }


                    SocialIcon(
                        modifier = Modifier.weight(1f),
                        unSelectedIcon = {
                            Icon(
                                imageVector = Icons.Filled.FavoriteBorder,
                                contentDescription = "",
                                tint = Color.Gray
                            )
                        },
                        selectedIcon = {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "",
                                tint = Color.Gray
                            )
                        },
                        isSelected = repeat
                    ) {
                        repeat = !repeat
                    }
                }
            }
        }

        TwitDivider()
    }
}

@Composable
fun HeaderCard(modifier: Modifier) {
    Row(modifier = modifier.fillMaxWidth()) {
        TextTitleCard(title = "Aris", modifier = Modifier.padding(end = 8.dp))
        DefaultTextCard(title = "@AristDevs", modifier = Modifier.padding(end = 8.dp))
        DefaultTextCard(title = "4h", modifier = Modifier.padding(end = 8.dp))
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Filled.DoNotDisturbOnTotalSilence,
            contentDescription = "show password",
            tint = Color.White
        )
    }
}

@Composable
fun SocialIcon(
    modifier: Modifier,
    unSelectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected: Boolean,
    onClick: () -> Unit
) {

    val default = 1
    val value = if (isSelected) (default + 1).toString() else default.toString()

    Row(
        modifier = modifier.clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isSelected) selectedIcon() else unSelectedIcon()

        Text(
            text = value,
            color = Color.White,
            modifier = modifier.padding(start = 4.dp),
            fontSize = 12.sp,

            )
    }

}

@Composable
fun LogoChild() {
    Image(
        painter = painterResource(id = R.drawable.mona_profile),
        contentDescription = "avatar",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(55.dp)
            .clip(CircleShape)
    )
}

@Composable
fun TextTitleCard(title: String, modifier: Modifier) {
    Text(text = title, modifier = modifier, color = Color.White, fontWeight = FontWeight.ExtraBold)
}

@Composable
fun DefaultTextCard(title: String, modifier: Modifier) {
    Text(text = title, modifier = modifier, color = Color.Gray)
}

@Composable
fun TwitDivider() {
    HorizontalDivider(
        Modifier
            .padding(top = 4.dp)
            .height(0.5.dp)
            .fillMaxWidth(),
        color = Color.Gray
    )
}