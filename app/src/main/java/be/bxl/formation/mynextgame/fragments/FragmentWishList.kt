package be.bxl.formation.mynextgame.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import be.bxl.formation.mynextgame.Db.GameDao
import be.bxl.formation.mynextgame.R
import be.bxl.formation.mynextgame.adapter.FavouriteGameAdapter
import be.bxl.formation.mynextgame.adapter.GameItemDeco
import be.bxl.formation.mynextgame.adapter.GameLastReleaseAdapter
import be.bxl.formation.mynextgame.models.Game


class FragmentWishList : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_wish_list, container, false)
        val wlfavouriteView = view.findViewById<RecyclerView>(R.id.wish_list_vertical_recycler_view)

        // Inflate the layout for this fragment
        val gameDao = GameDao(requireContext())

        gameDao.openReadable()
        val games: List<Game> = gameDao.all as List<Game>

        println("----------------------------------------------------------$games----------------------------------------------------------")
        val w1 = games.get(0)
        println("---------- !!! we are looking for $w1")
        /*
        wlfavouriteView.adapter = FavouriteGameAdapter(R.layout.item_vertical_wish_list, games)
        wlfavouriteView.addItemDecoration(GameItemDeco())
        */


        gameDao.close()
        //val arrayAdapter: ArrayAdapter<Game> = ArrayAdapter<Game>(this, android.R.id.simpleListView, games)
        return view
    }

}