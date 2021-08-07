package be.bxl.formation.mynextgame.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import be.bxl.formation.mynextgame.adapter.GameAdapter
import be.bxl.formation.mynextgame.R
import be.bxl.formation.mynextgame.adapter.GameItemDeco

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater?.inflate(R.layout.fragment_home, container, false)

        //recuperer recylcler view popular games
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.popular_game_horizontal_recycler_view)
        horizontalRecyclerView.adapter = GameAdapter(R.layout.item_horizontal_game)

        //récuper recycler view vertical last releases
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.last_game_vertical_recycler_view)
        verticalRecyclerView.adapter = GameAdapter(R.layout.item_vertical_game)
        verticalRecyclerView.addItemDecoration(GameItemDeco())
        return view
    }
}