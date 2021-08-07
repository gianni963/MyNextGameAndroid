package be.bxl.formation.mynextgame.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Game(

    //Classe Game contenant les valeurs à récupérer dans l'api IGDB
    @SerializedName("name")
    val name: String ?,

    @SerializedName("cover.url")
    val cover_url : String?,

    @SerializedName("first_release_date")
    val first_release_date : String?,

    @SerializedName("total_rating_count")
    val total_rating_count : String?,

    @SerializedName("platforms.abbreviation")
    val platforms_abbreviation : String?,

    @SerializedName("rating")
    val rating : String?,

    @SerializedName("slug")
    val slug : String?,


) : Parcelable {
    constructor() : this("","","","","","","")
}

