package be.bxl.formation.mynextgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import be.bxl.formation.mynextgame.fragments.HomeFragment
import be.bxl.formation.mynextgame.models.Game
import be.bxl.formation.mynextgame.models.GameResponse
import be.bxl.formation.mynextgame.services.GameApiService
import be.bxl.formation.mynextgame.services.GameApiInterface
import kotlinx.android.synthetic.main.activity_main.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, HomeFragment())
        transaction.addToBackStack(null)
        transaction.commit()

     /*   rv_games_list.layoutManager = LinearLayoutManager(this)
        rv_games_list.setHasFixedSize(true)
        getGameData { games : List<Game> ->
            rv_games_list.adapter = GameAdapter(games)
        } */

    }

    //Liste des jeux
   /* private fun getGameData(callback: (List<Game>) -> Unit){
        val apiService = GameApiService.getInstance().create(GameApiInterface::class.java)

        apiService.getGameList().enqueue(object : Callback<GameResponse> {

            override fun onResponse(call: Call<GameResponse>, response: Response<GameResponse>) {
                return callback(response.body()!!.games)

            }

            override fun onFailure(call: Call<GameResponse>, t: Throwable) {
            }

        })
    }*/
}