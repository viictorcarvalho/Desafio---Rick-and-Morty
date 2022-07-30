package br.com.zup.desafio_rickandmorty.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.zup.desafio_rickandmorty.data.model.CharacterResult

@Dao
interface CharacterDAO {
    @Query("SELECT * FROM character ORDER BY id ASC")
    fun getAllCharacter(): List<CharacterResult>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAllCharacters(listCharacter: List<CharacterResult>)
}