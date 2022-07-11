package br.com.zup.desafio_rickandmorty.ui.character.view

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.zup.desafio_rickandmorty.data.model.CharacterResult
import br.com.zup.desafio_rickandmorty.databinding.FragmentItemBinding
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(
    private var listCharacter: MutableList<CharacterResult>,
    private val click : (character : CharacterResult) -> Unit
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            FragmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    fun updateList(newList: MutableList<CharacterResult>){
        listCharacter = newList

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = listCharacter[position]
        holder.displayDataList(character)

        holder.binding.cvCharacter.setOnClickListener {
            click(character)
        }
    }

    override fun getItemCount(): Int = listCharacter.size

    class ViewHolder(val binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun displayDataList(character: CharacterResult) {
            binding.tvCharacterName.text = character.name
            Picasso.get().load(character.image).into(binding.ivCharacterImage)
        }
    }

}