package br.com.zup.desafio_rickandmorty.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.zup.desafio_rickandmorty.data.datasource.local.dao.CharacterDAO
import br.com.zup.desafio_rickandmorty.data.model.CharacterResult

@Database(entities = [CharacterResult::class], version = 1)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDAO(): CharacterDAO

    companion object {
        @Volatile
        private var INSTANCE: CharacterDatabase? = null

        fun getDatabase(context: Context): CharacterDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CharacterDatabase::class.java,
                    "rickandmorty_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}