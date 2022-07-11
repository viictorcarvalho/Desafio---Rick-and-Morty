package br.com.zup.desafio_rickandmorty.ui.character.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.desafio_rickandmorty.KEY
import br.com.zup.desafio_rickandmorty.R
import br.com.zup.desafio_rickandmorty.data.model.CharacterResult
import br.com.zup.desafio_rickandmorty.databinding.FragmentCharacterBinding
import br.com.zup.desafio_rickandmorty.ui.viewstate.ViewState
import br.com.zup.desafio_rickandmorty.ui.character.viewmodel.CharacterViewModel

class CharacterFragment : Fragment() {
    private lateinit var binding: FragmentCharacterBinding
    private val adapter: RecyclerViewAdapter by lazy {
        RecyclerViewAdapter(arrayListOf(), ::goToDetailsCharacter)
    }
    private val viewModel: CharacterViewModel by lazy {
        ViewModelProvider(this)[CharacterViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        viewModel.getDataCharacterNetwork()

        showRecycleView()
        (activity as HomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    fun initObserver() {
        viewModel.state.observe(this.viewLifecycleOwner) {
            when (it) {
                is ViewState.Success -> {
                    adapter.updateList(it.data.toMutableList())
                }
                is ViewState.Error -> {
                    Toast.makeText(context, "Erro de conexão!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun showRecycleView() {
        binding.list.adapter = adapter
        binding.list.layoutManager = GridLayoutManager(context, 2)
    }

    fun goToDetailsCharacter(character: CharacterResult) {
        val bundle = bundleOf(KEY to character)
        NavHostFragment.findNavController(this).navigate(R.id.action_characterFragment_to_detailFragment, bundle)
    }
}