package com.example.mobilechallengezappts.ui

import android.view.View
import android.widget.ImageView
import com.example.mobilechallengezappts.R

class PokemonUIDetails() {
    fun checkPokemonType(view: ImageView, type: String) {
        when (type.lowercase()) {
            "fire" -> {
                view.setImageResource(R.drawable.ic_type_fire)
                view.visibility = View.VISIBLE
            }
            "water" -> {
                view.setImageResource(R.drawable.ic_type_water)
                view.visibility = View.VISIBLE
            }
            "grass" -> {
                view.setImageResource(R.drawable.ic_type_grass)
                view.visibility = View.VISIBLE
            }
            "psychic" -> {
                view.setImageResource(R.drawable.ic_type_psychic)
                view.visibility = View.VISIBLE
            }
            "poison" -> {
                view.setImageResource(R.drawable.ic_type_poison)
                view.visibility = View.VISIBLE
            }
            "flying" -> {
                view.setImageResource(R.drawable.ic_type_flying)
                view.visibility = View.VISIBLE
            }
            "rock" -> {
                view.setImageResource(R.drawable.ic_type_rock)
                view.visibility = View.VISIBLE
            }
            "fighting" -> {
                view.setImageResource(R.drawable.ic_type_fighting)
                view.visibility = View.VISIBLE
            }
            "electric" -> {
                view.setImageResource(R.drawable.ic_type_electric)
                view.visibility = View.VISIBLE
            }
            "ground" -> {
                view.setImageResource(R.drawable.ic_type_ground)
                view.visibility = View.VISIBLE
            }
            "steel" -> {
                view.setImageResource(R.drawable.ic_type_steel)
                view.visibility = View.VISIBLE
            }
            "normal" -> {
                view.setImageResource(R.drawable.ic_type_normal)
                view.visibility = View.VISIBLE
            }
            else -> view.visibility = View.GONE
        }
    }
}

