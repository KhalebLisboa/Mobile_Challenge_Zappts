package com.example.mobilechallengezappts.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilechallengezappts.databinding.FragmentMainBinding
import com.example.mobilechallengezappts.viewmodel.PokemonViewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    lateinit var viewModel: PokemonViewModel
    lateinit var layoutManager : LinearLayoutManager
    lateinit var adapter : ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = LinearLayoutManager(requireContext())
        adapter = ListAdapter(requireContext())
        viewModel = ViewModelProvider(requireActivity())[PokemonViewModel::class.java]

        viewModel.getPokemonData()
        binding.recyclerviewMain.adapter = adapter
        binding.recyclerviewMain.layoutManager = layoutManager

        viewModel.pokemon.observe(viewLifecycleOwner, {
            adapter.onUpdate(it)
        })

        setOnScroll()
    }


    private fun setOnScroll(){
        binding.recyclerviewMain.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val pastVisibleItem = layoutManager.findLastVisibleItemPosition()
                val total = adapter.itemCount

                if ((pastVisibleItem + 1) >= total){
                    viewModel.getPokemonData()
                }
            }
        })
    }
}