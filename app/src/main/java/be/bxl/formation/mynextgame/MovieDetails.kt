package be.bxl.formation.mynextgame

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import be.bxl.formation.mynextgame.MainActivity
import be.bxl.formation.mynextgame.R
import be.bxl.formation.mynextgame.models.Game
import be.bxl.formation.mynextgame.models.GameResponse
import be.bxl.formation.mynextgame.services.GameApiInterface
import be.bxl.formation.mynextgame.services.GameApiService
import com.bumptech.glide.Glide
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_register_user.*
import kotlinx.android.synthetic.main.item_vertical_game.view.*
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieDetails : AppCompatActivity(){
    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val extraIdData = intent.getStringExtra("IDGame")
        val titleIdData = intent.getStringExtra("TitleGame")
        val coverMovieData = intent.getStringExtra("CoverGame")

        Toast.makeText(
            this,
            "Movie with id $extraIdData ,$titleIdData, $coverMovieData retrieved",
            Toast.LENGTH_LONG
        ).show()

        val titleMovie: TextView = findViewById(R.id.movie_details_title)
        val releaseMovie: TextView = findViewById(R.id.movies_release_date)
        val coverMovie: ImageView = findViewById(R.id.cover_details_movie)
        titleMovie.setText(titleIdData)
        releaseMovie.setText(extraIdData)
        Glide.with(this).load(IMAGE_BASE + coverMovieData).into(coverMovie)



    }

}