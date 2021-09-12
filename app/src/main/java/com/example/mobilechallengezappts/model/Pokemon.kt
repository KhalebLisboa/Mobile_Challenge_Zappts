package com.example.mobilechallengezappts.model

class Pokemon(
    val id : Int = 0,
    val name : String = "",
    val types : List<Type>,
    val weight : Int = 0,
    val height : Int = 0,
    val sprites : Sprites
)