package br.com.zup.desafio_rickandmorty.data.model


import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("results")
    val results: List<CharacterResult>
)