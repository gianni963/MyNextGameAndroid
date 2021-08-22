package be.bxl.formation.mynextgame.models

import android.os.Parcelable
import android.provider.MediaStore.Video
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import okhttp3.internal.platform.Platform

@Parcelize
data class Game (

    //for test
    @SerializedName("id")
    val id : String ?,

    @SerializedName("title")
    val title : String?,

    @SerializedName("poster_path")
    val poster : String?,

    @SerializedName("release_date")
    val release : String?
    /*
       @SerializedName("name")
       @Expose
       var name: String? = null

       @SerializedName("id")
       @Expose
       var id: Int? = null

       @SerializedName("cover")
       @Expose
       var cover: Any? = null


       @SerializedName("popularity")
       @Expose
       var popularity: Double? = null

       @SerializedName("summary")
       @Expose
       var summary: String? = null

       @SerializedName("genres")
       @Expose
       var genres: List<Any>? = null

       @SerializedName("platforms")
       @Expose
       var platforms: List<Platform>? = null

       @SerializedName("rating")
       @Expose
       var rating: Double? = null

       @SerializedName("release_dates")
       @Expose
       var releaseDates: List<Any>? = null

       @SerializedName("videos")
       @Expose
       var videos: List<Video>? = null
        */
) : Parcelable {
    constructor() : this("", "", "", "")
}