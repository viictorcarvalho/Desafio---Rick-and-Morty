package br.com.zup.desafio_rickandmorty.ui.character.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.zup.desafio_rickandmorty.data.model.CharacterResult
import br.com.zup.desafio_rickandmorty.domain.usecase.CharacterUseCase
import br.com.zup.desafio_rickandmorty.ui.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class CharacterViewModel (application: Application) : AndroidViewModel(application){
    val useCase = CharacterUseCase(application)
    val state = MutableLiveData<ViewState<List<CharacterResult>>>()

    fun getDataCharacterNetwork() {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO){
                    useCase.getAllCharacters()
                }
                state.value = response
            }
            catch (e : Exception){
                state.value = ViewState.Error(Throwable("Erro"))
            }
        }
    }
}