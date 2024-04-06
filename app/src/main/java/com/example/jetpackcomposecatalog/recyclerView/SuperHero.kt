package com.example.jetpackcomposecatalog.recyclerView

import androidx.annotation.DrawableRes

data class SuperHero(
    var superHeroName: String,
    var realName: String,
    var publiser: String,
    @DrawableRes var photo: Int
)
