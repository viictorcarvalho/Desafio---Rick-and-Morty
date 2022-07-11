package br.com.zup.desafio_rickandmorty.data.model

import com.google.gson.annotations.SerializedName

data class CharacterResult(
    @SerializedName("gender")
    var gender: String = "",
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("image")
    var image: String = "",
    @SerializedName("name")
    var name: String = "",
    @SerializedName("species")
    var species: String = "",
    @SerializedName("status")
    var status: String = ""
    )