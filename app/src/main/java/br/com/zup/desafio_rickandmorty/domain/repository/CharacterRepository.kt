package br.com.zup.desafio_rickandmorty.domain.repository

import android.app.Application
import br.com.zup.desafio_rickandmorty.data.datasource.local.CharacterDatabase
import br.com.zup.desafio_rickandmorty.data.datasource.remote.RetrofitService
import br.com.zup.desafio_rickandmorty.data.model.CharacterResponse
import br.com.zup.desafio_rickandmorty.data.model.CharacterResult

class CharacterRepository(application: Application) {
    val characterDAO = CharacterDatabase.getDatabase(application).characterDAO()

    suspend fun getAllCharacterNetwork(): CharacterResponse {
        return RetrofitService.apiService.getAllCharacter()
    }

    fun getAllCharactersDB(): List<CharacterResult> {
        return characterDAO.getAllCharacter()
    }

    fun insertAllCharactersDB(listCharacter: List<CharacterResult>) {
        characterDAO.insertAllCharacters(listCharacter)
    }
}