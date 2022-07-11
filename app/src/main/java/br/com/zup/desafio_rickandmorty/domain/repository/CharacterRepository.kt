package br.com.zup.desafio_rickandmorty.domain.repository

import br.com.zup.desafio_rickandmorty.data.datasource.remote.RetrofitService
import br.com.zup.desafio_rickandmorty.data.model.CharacterResponse

class CharacterRepository {

    suspend fun getAllCharacterNetwork(): CharacterResponse{
        return RetrofitService.apiService.getAllCharacter()
    }
}