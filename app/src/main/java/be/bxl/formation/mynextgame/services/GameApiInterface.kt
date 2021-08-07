package be.bxl.formation.mynextgame.services


import be.bxl.formation.mynextgame.models.GameResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface GameApiInterface {
    //Interface contenant la requête vers l'api, change notre http api en interface Java doit contenir un header et un body. Dans le header de la requête fournir client-id et authorization ( fonctionne, testé sur Postman)
    @Headers(
        "Client-ID: 51p3gbvxlg1l16mj6sa2te5ctekbyy",
        "Authorization: Bearer 4xysvvas1lxxasuxmw4dzagf9ut85z"
    )
    @POST("/games")
    fun getGameList(@Query("fields") fields: String): Call<GameResponse>
}