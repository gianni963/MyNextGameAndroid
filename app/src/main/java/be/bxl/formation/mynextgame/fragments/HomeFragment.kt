package be.bxl.formation.mynextgame.fragments

import be.bxl.formation.mynextgame.models.Game
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import be.bxl.formation.mynextgame.adapter.GameLastReleaseAdapter
import be.bxl.formation.mynextgame.R
import be.bxl.formation.mynextgame.adapter.GameAdapter
import be.bxl.formation.mynextgame.adapter.GameItemDeco

import be.bxl.formation.mynextgame.models.GameResponse

import be.bxl.formation.mynextgame.services.GameApiInterface
import be.bxl.formation.mynextgame.services.GameApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater?.inflate(R.layout.fragment_home, container, false)
        //Liste des jeux

        //recuperer recylcler view popular games + ajouter data de l'api
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.popular_game_horizontal_recycler_view)
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.last_game_vertical_recycler_view)

        getGameData { games : List<Game> ->
            //recuperer recylcler view popular games + ajouter data de l'api
            val w1 = games.get(0)
            println("---------- !!! we are looking for $w1")
            //récuper recycler view vertical last releases
            horizontalRecyclerView.adapter = GameAdapter(R.layout.item_horizontal_game,games)
        }

        getLastGamesData { games : List<Game> ->
            //recuperer recylcler view popular games + ajouter data de l'api
            val w1 = games.get(0)
            println("---------- !!! we are looking for $w1")
            verticalRecyclerView.adapter = GameLastReleaseAdapter(R.layout.item_vertical_game,games)
            verticalRecyclerView.addItemDecoration(GameItemDeco())

        }


        return view
    }

    private fun getGameData(callback: (List<Game>) -> Unit){
        val apiService = GameApiService.getInstance().create(GameApiInterface::class.java)

        apiService.getAllGames().enqueue(object : Callback<GameResponse> {
            override fun onFailure(call: Call<GameResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<GameResponse>, response: Response<GameResponse>) {
                return callback(response.body()!!.games)
            }

        })
    }

    private fun getLastGamesData(callback: (List<Game>) -> Unit){
        val apiService = GameApiService.getInstance().create(GameApiInterface::class.java)

        apiService.getLastGames().enqueue(object : Callback<GameResponse> {
            override fun onFailure(call: Call<GameResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<GameResponse>, response: Response<GameResponse>) {
                return callback(response.body()!!.games)
            }

        })
    }
}