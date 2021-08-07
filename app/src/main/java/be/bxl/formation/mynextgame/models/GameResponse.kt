package be.bxl.formation.mynextgame.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GameResponse(
    @SerializedName("games")
    val games : List<Game>
) : Parcelable {
    constructor() : this(mutableListOf())

}