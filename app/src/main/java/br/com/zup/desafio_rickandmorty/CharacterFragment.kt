package br.com.zup.desafio_rickandmorty

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.desafio_rickandmorty.databinding.FragmentCharacterBinding
import br.com.zup.desafio_rickandmorty.domain.repository.CharacterRepository

class CharacterFragment : Fragment() {
    private lateinit var binding: FragmentCharacterBinding
    private val adapter: RecyclerViewAdapter by lazy {
        RecyclerViewAdapter(arrayListOf() )//, :: goToDetailsCharacter)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()

    }
}