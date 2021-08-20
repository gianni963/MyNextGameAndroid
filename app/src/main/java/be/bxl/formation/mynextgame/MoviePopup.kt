package be.bxl.formation.mynextgame

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import be.bxl.formation.mynextgame.adapter.GameAdapter

class MoviePopup(
    private val adapter: GameAdapter
) : Dialog(adapter.context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.popup_movies_details)

        //TODO DISPLAY POPUP WITH MOVIE INFOS WHEN USER PRESS AND HOLD A AN IMAGE MOVIE FROM RECYCLER VIEW
    }
}