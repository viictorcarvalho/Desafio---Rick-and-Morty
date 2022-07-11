package br.com.zup.desafio_rickandmorty.data.model

import com.google.gson.annotations.SerializedName

data class CharacterResult(
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    val status: String
    )