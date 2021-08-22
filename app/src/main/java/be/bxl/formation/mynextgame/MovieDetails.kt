package be.bxl.formation.mynextgame

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import be.bxl.formation.mynextgame.Db.GameDao
import be.bxl.formation.mynextgame.models.Game
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_register_user.*
import kotlinx.android.synthetic.main.item_vertical_game.view.*


class MovieDetails : AppCompatActivity(){
    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val extraIdData = intent.getStringExtra("IDGame")
        val titleIdData = intent.getStringExtra("TitleGame")
        val coverMovieData = intent.getStringExtra("CoverGame")
        val releaseMovieData = intent.getStringExtra("ReleaseGame")

        Toast.makeText(
            this,
            "Movie with id $extraIdData ,$titleIdData, $coverMovieData retrieved",
            Toast.LENGTH_LONG
        ).show()

        val titleMovie: TextView = findViewById(R.id.movie_details_title)
        val idMovie: TextView = findViewById(R.id.id_movies)
        val coverMovie: ImageView = findViewById(R.id.cover_details_movie)
        val releaseMovie: TextView = findViewById(R.id.movies_release_date)
        titleMovie.setText(titleIdData)
        idMovie.setText(extraIdData)
        releaseMovie.setText(releaseMovieData)

        Glide.with(this).load(IMAGE_BASE + coverMovieData).into(coverMovie)

        //User click on the star
        val favouriteIcon : ImageView = findViewById(R.id.favourite_movie)
        favouriteIcon.setOnClickListener{
            val gameDao = GameDao(applicationContext)

            val movie1 = Game(extraIdData,titleIdData,coverMovieData,releaseMovieData)

            gameDao.openWritable()
            gameDao.insert(movie1)
            gameDao.close()

            gameDao.openReadable()
            val games: List<Any> = gameDao.all

            gameDao.close()
        }

    }

}