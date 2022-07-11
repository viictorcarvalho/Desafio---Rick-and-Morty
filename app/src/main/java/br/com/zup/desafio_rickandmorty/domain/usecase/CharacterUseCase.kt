package br.com.zup.desafio_rickandmorty.domain.usecase

import android.app.Application
import br.com.zup.desafio_rickandmorty.data.model.CharacterResult
import br.com.zup.desafio_rickandmorty.domain.repository.CharacterRepository
import br.com.zup.desafio_rickandmorty.ui.viewstate.ViewState

class CharacterUseCase(application: Application) {
    private val charactersRepository = CharacterRepository(application)

    suspend fun getAllCharacters(): ViewState<List<CharacterResult>> {
        return try {
            val response = charactersRepository.getAllCharacterNetwork()
            ViewState.Success(response.results)

        }catch (e: Exception){
            ViewState.Error(Exception("Erro"))
        }
    }
}