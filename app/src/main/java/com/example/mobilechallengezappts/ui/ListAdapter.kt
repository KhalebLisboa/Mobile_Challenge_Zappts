package com.example.mobilechallengezappts.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mobilechallengezappts.R
import com.example.mobilechallengezappts.databinding.LayoutRecyclerviewItemBinding
import com.example.mobilechallengezappts.model.Pokemon

class ListAdapter(
    var context : Context) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private var listPokemon = ArrayList<Pokemon>()

    class ViewHolder(view : LayoutRecyclerviewItemBinding) : RecyclerView.ViewHolder(view.root){
        var binding = LayoutRecyclerviewItemBinding.bind(view.root)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bind = LayoutRecyclerviewItemBinding.inflate(LayoutInflater.from(context),parent, false)
        return ViewHolder(bind)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imgTypeWater.visibility = View.GONE
        holder.binding.imgTypeFire.visibility = View.GONE
        holder.binding.txtName.text = listPokemon[position].name
        holder.binding.txtId.text = listPokemon[position].id.toString()

        PokemonUIDetails().checkPokemonType(
            holder.binding.imgTypeWater,
            listPokemon[position].types[0].type.name)

        if (listPokemon[position].types.size > 1)
            PokemonUIDetails().checkPokemonType(
                holder.binding.imgTypeFire,
                listPokemon[position].types[1].type.name
            )

        Glide.with(context)
            .load(listPokemon[position].sprites.other.official_artwork.front_default)
            .into(holder.binding.imgPokemon)

        holder.binding.materialCardIcon.setOnClickListener {

            val bundle = bundleOf("id" to position)
            it.findNavController().navigate(R.id.action_mainFragment_to_detailsFragment, bundle)
        }

    }

    override fun getItemCount(): Int {
        return  listPokemon.size
    }

    fun onUpdate(list : List<Pokemon>){
        listPokemon.clear()
        listPokemon.addAll(list)
        notifyDataSetChanged()
    }
}