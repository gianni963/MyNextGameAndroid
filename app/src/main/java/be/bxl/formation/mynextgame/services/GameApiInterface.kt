package be.bxl.formation.mynextgame.services

import be.bxl.formation.mynextgame.models.Game
import be.bxl.formation.mynextgame.models.GameResponse
import retrofit2.Call
import retrofit2.http.*


interface GameApiInterface {
    //Interface contenant la requête vers l'api, change notre http api en interface Java , Post, doit contenir un header et un body. Dans le header de la requête fournir client-id et authorization ( fonctionne, testé sur Postman)
    /*@FormUrlEncoded    // annotation that used with POST type request
    @Headers(
        "Client-ID: 51p3gbvxlg1l16mj6sa2te5ctekbyy",
        "Authorization: Bearer 4xysvvas1lxxasuxmw4dzagf9ut85z"
    )
    @POST("/games")
   Request to get popular games (in Post) ->
        "fields name, cover.url, first_release_date, total_rating_count, platforms.abbreviation, rating, slug;
        where platforms = (48,49,130,6)
        & (first_release_date >= {$before}
        & first_release_date < {$after}
        & total_rating_count > 5);
        sort total_rating_count desc;
        limit 12;", "text/plain"

     @FormUrlEncoded    // annotation that used with POST type request
    @Headers(
        "Client-ID: 51p3gbvxlg1l16mj6sa2te5ctekbyy",
        "Authorization: Bearer 4xysvvas1lxxasuxmw4dzagf9ut85z"
    )

     @POST("/games")
   Request to get last release (in Post) ->

    "fields name, cover.url, first_release_date, total_rating_count, platforms.abbreviation, rating, rating_count, summary, slug;
    where platforms = (48,49,130,6)
    & (first_release_date >= {$before}
    & first_release_date < {$current}
    & rating_count > 5);
    sort total_rating_count desc;
    limit 3;
", "text/plain"
     */
    @GET("trending/all/day?api_key=eb3be908ef3e581fa7fad067e30d4c21&language=fr")
    fun getAllGames(): Call<GameResponse>

    @GET("movie/upcoming?api_key=eb3be908ef3e581fa7fad067e30d4c21&language=fr&page=1")
    fun getLastGames(): Call<GameResponse>


}

