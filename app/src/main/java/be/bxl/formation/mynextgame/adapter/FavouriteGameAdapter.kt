package be.bxl.formation.mynextgame.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import be.bxl.formation.mynextgame.MainActivity
import be.bxl.formation.mynextgame.MoviePopup
import be.bxl.formation.mynextgame.RegisterUser
import be.bxl.formation.mynextgame.models.Game
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.item_vertical_wish_list.view.*
import kotlinx.android.synthetic.main.item_vertical_wish_list.view.image_item

class FavouriteGameAdapter(
    private val layoutId: Int,
    private val games : List<Game>,
    val context : Context
    ) : RecyclerView.Adapter<FavouriteGameAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"


        fun bindGame(game: Game) {
            val w1 = game
            println("!!---------- !!! we are looking for $w1")
            itemView.name_wl_item.text = game.title
            itemView.release_wl_item.text = game.release
            //itemView.id_wl_item.text = game.id
            Glide.with(itemView).load(IMAGE_BASE + game.poster).into(itemView.image_item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindGame(games[position])



    }
    override fun getItemCount(): Int = 10
}