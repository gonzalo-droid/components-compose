package com.example.jetpackcomposecatalog.recyclerView

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecatalog.R

@Composable
fun SuperHeroRecyclerView() {
    val context = LocalContext.current
    Column {
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(getSuperHero()) { superhero ->
                ItemHero(superHero = superhero, onItemSelected = {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                })
            }
        }

        HorizontalDivider(Modifier.padding(10.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(getSuperHero()) { superhero ->
                ItemHero(superHero = superhero, onItemSelected = {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                })
            }
        }
    }

}

@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Gray),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemSelected(superHero) }) {
        Column {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "SuperHero",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superHero.superHeroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.publiser,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp),
                fontSize = 10.sp
            )
        }
    }
}


fun getSuperHero(): List<SuperHero> {
    return listOf(
        SuperHero("Hero 1", "humano 1", "Marvel", R.drawable.mona_profile),
        SuperHero("Hero 2", "humano 2", "Marvel", R.drawable.mona_profile),
        SuperHero("Hero 3", "humano 3", "DC", R.drawable.mona_profile),
        SuperHero("Hero 4", "humano 4", "DC", R.drawable.mona_profile),
        SuperHero("Hero 5", "humano 5", "Marvel", R.drawable.mona_profile),
        SuperHero("Hero 6", "humano 6", "DC", R.drawable.mona_profile),
        SuperHero("Hero 7", "humano 7", "Marvel", R.drawable.mona_profile),
    )
}