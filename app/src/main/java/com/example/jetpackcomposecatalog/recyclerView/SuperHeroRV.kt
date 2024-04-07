package com.example.jetpackcomposecatalog.recyclerView

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecatalog.R
import kotlinx.coroutines.launch

@Composable
fun MonaRecyclerView() {
    val context = LocalContext.current
    ColumnRecyclerStickyView(context)
}

// sticky
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ColumnRecyclerStickyView(context: Context) {
    val list: Map<String, List<SuperHero>> = getSuperHero().groupBy { it.publiser }
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        list.forEach { (publiser, myHero) ->

            stickyHeader {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Gray)
                ) {
                    Text(
                        text = publiser,
                        modifier = Modifier
                            .padding(vertical =  20.dp, horizontal = 8.dp),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }

            items(myHero) { superhero ->
                ItemHero(superHero = superhero, onItemSelected = {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                })
            }
        }
    }
}


// grib recycler
@Composable
fun GridRecyclerView(context: Context) {
    LazyVerticalGrid(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        columns = GridCells.Fixed(2),
        content = {
            items(getSuperHero()) { superhero ->
                ItemHero(superHero = superhero, onItemSelected = {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                })
            }
        }, contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 16.dp
        )
    )
}


// event handle in recycler
@Composable
fun ColumnSpecialControlRecyclerView(context: Context) {
    val rvState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column(Modifier.fillMaxWidth()) {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
                .weight(1f)
        ) {
            items(getSuperHero()) { superhero ->
                ItemHero(superHero = superhero, onItemSelected = {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                })
            }
        }

        val isShow by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }

        // TODO: rvState.firstVisibleItemScrollOffset

        if (isShow) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        rvState.animateScrollToItem(0)
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(text = "No touch me")
            }
        }
    }
}


// simple horizontal recycler
@Composable
fun RowRecyclerView(context: Context) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHero()) { superhero ->
            ItemHero(superHero = superhero, onItemSelected = {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
            })
        }
    }
}


// simple vertical recycler
@Composable
fun ColumnRecyclerView(context: Context) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHero()) { superhero ->
            ItemHero(superHero = superhero, onItemSelected = {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
            })
        }
    }
}


// data item
@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Gray),
        modifier = Modifier
            .fillMaxWidth()
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