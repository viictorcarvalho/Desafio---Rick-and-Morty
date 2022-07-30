package br.com.zup.desafio_rickandmorty.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "character")
data class CharacterResult(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0,

    @SerializedName("gender")
    var gender: String = "",
    @SerializedName("image")
    var image: String = "",
    @SerializedName("name")
    var name: String = "",
    @SerializedName("species")
    var species: String = "",
    @SerializedName("status")
    var status: String = ""
    )
    : Parcelable