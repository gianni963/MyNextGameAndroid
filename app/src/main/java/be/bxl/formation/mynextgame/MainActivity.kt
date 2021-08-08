package be.bxl.formation.mynextgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import be.bxl.formation.mynextgame.fragments.HomeFragment
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

        //ajout Fragment Home
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, HomeFragment())
        transaction.addToBackStack(null)
        transaction.commit()

    }


}