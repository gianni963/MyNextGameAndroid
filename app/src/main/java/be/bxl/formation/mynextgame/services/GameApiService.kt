package be.bxl.formation.mynextgame.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GameApiService {
    companion object{
        private const val BASE_URL = "https://api.igdb.com/v4/"
        private var retrofit : Retrofit? = null

        fun getInstance() : Retrofit{

            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}