package com.example.mobilechallengezappts.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.mobilechallengezappts.databinding.FragmentDetailsBinding
import com.example.mobilechallengezappts.viewmodel.PokemonViewModel

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    lateinit var viewModel: PokemonViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgTypeOne.visibility = View.GONE
        binding.imgTypeTwo.visibility = View.GONE

        viewModel = ViewModelProvider(requireActivity())[PokemonViewModel::class.java]
        val pokemon = arguments?.let { viewModel.pokemon.value?.get(it.getInt("id")) }

        binding.txtName.text = pokemon?.name
        binding.txtId.text = pokemon?.id.toString()

        Glide.with(requireContext())
            .load(pokemon!!.sprites.other.official_artwork.front_default)
            .into(binding.imgPokemon)

        PokemonUIDetails().checkPokemonType(binding.imgTypeOne, pokemon.types[0].type.name)

        if (pokemon.types.size > 1)
            PokemonUIDetails().checkPokemonType(binding.imgTypeTwo, pokemon.types[1].type.name)

        binding.txtAltura.text = pokemon.height.toString() + " m"
        binding.txtPeso.text = pokemon.weight.toString() + " Kg"

    }
}