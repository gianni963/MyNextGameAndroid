package be.bxl.formation.mynextgame.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import be.bxl.formation.mynextgame.MainActivity
import be.bxl.formation.mynextgame.MoviePopup
import be.bxl.formation.mynextgame.RegisterUser
import be.bxl.formation.mynextgame.models.Game
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.item_horizontal_game.view.*
import kotlinx.android.synthetic.main.item_vertical_game.view.*
import kotlinx.android.synthetic.main.item_vertical_game.view.image_item

class GameAdapter(
    private val layoutId: Int,
    private val games : List<Game>,
    val context : Context,
    val onClickGame : (Game) -> Unit
    ) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //val GameImage = view.findViewById<ImageView>(R.id.image_item)
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
//        init{
//            itemView.setOnClickListener { v: View ->
//                val position: Int = adapterPosition
//                Toast.makeText(
//                    itemView.context,
//                    "you click on item # ${position + 1} ",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }



        fun bindGame(game: Game) {
            val w1 = game
            println("!!---------- !!! we are looking for $w1")
            itemView.name_popular_item.text = game.title
            itemView.platform_popular_item.text = game.release
            itemView.id_popular_item.text = game.id
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
        holder.itemView.setOnClickListener{ v: View ->
            val currentGame = games[position]
            this.onClickGame(currentGame)


       }


    }

    override fun getItemCount(): Int = 5
}