package br.com.zup.desafio_rickandmorty.data.datasource.remote

import br.com.zup.desafio_rickandmorty.data.model.CharacterResponse
import retrofit2.http.GET

interface TheRickAndMortyAPI {
    @GET("character")
    suspend fun getAllCharacter(): CharacterResponse
}