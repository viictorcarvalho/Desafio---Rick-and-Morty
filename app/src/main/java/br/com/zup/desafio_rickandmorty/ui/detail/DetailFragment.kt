package br.com.zup.desafio_rickandmorty.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.desafio_rickandmorty.KEY
import br.com.zup.desafio_rickandmorty.data.model.CharacterResult
import br.com.zup.desafio_rickandmorty.databinding.FragmentDetailBinding
import br.com.zup.desafio_rickandmorty.ui.character.view.HomeActivity
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataCharacter()

        (activity as HomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun getDataCharacter() {
        val character = arguments?.getParcelable<CharacterResult>(KEY)
        character?.let {
            binding.tvCharacterName.text = "Nome: " + it.name
            binding.tvCharacterGender.text = "Gênero: " + it.gender
            binding.tvCharacterSpecies.text = "Espécie: " + it.species
            binding.tvCharacterStatus.text = "Status: " + it.status
            Picasso.get().load(it.image).into(binding.ivCharacterImage)

            (activity as HomeActivity).supportActionBar?.title = it.name
        }
    }
}