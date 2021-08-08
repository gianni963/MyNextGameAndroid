package be.bxl.formation.mynextgame.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import be.bxl.formation.mynextgame.models.Game
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_vertical_game.view.*

class GameLastReleaseAdapter(
    private val layoutId: Int,
    private val games : List<Game>
) : RecyclerView.Adapter<GameLastReleaseAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //val GameImage = view.findViewById<ImageView>(R.id.image_item)
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindGame(game: Game) {

            itemView.name_item.text = game.title
            itemView.platform_item.text = game.release
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

    override fun getItemCount(): Int = 5
}