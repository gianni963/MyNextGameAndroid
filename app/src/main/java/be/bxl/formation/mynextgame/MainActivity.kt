package be.bxl.formation.mynextgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import be.bxl.formation.mynextgame.Db.GameDao
import be.bxl.formation.mynextgame.fragments.FragmentLogin
import be.bxl.formation.mynextgame.fragments.FragmentSearch
import be.bxl.formation.mynextgame.fragments.FragmentWishList
import be.bxl.formation.mynextgame.fragments.HomeFragment
import be.bxl.formation.mynextgame.models.Game
import be.bxl.formation.mynextgame.models.GameResponse
import be.bxl.formation.mynextgame.services.GameApiService
import be.bxl.formation.mynextgame.services.GameApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_wish_list.view.*


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val FragmentLogin = FragmentLogin()
    private val HomeFragment = be.bxl.formation.mynextgame.fragments.HomeFragment()
    private val FragmentWishList = FragmentWishList()
    private val FragmentSearch = be.bxl.formation.mynextgame.fragments.FragmentSearch()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ajout Fragment Home
        /*val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, HomeFragment())
        transaction.addToBackStack(null)
        transaction.commit()*/

        replacefragment(HomeFragment())

        bottom_navigation.setOnItemSelectedListener() {
            when(it.itemId){
                R.id.ic_home -> replacefragment(HomeFragment)
                R.id.ic_my_space -> replacefragment(FragmentLogin)
                R.id.ic_search -> replacefragment(FragmentSearch)
                R.id.ic_wishlist -> replacefragment(FragmentWishList)
            }
            true
        }

        val userId = intent.getStringExtra("user_id")
        val emailId = intent.getStringExtra("email_id")


        }

    private fun replacefragment(fragment: Fragment) {
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }


}