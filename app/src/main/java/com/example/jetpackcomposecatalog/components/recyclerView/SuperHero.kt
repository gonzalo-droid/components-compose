package com.example.jetpackcomposecatalog.components.recyclerView

import androidx.annotation.DrawableRes

data class SuperHero(
    var superHeroName: String,
    var realName: String,
    var publiser: String,
    @DrawableRes var photo: Int
)
