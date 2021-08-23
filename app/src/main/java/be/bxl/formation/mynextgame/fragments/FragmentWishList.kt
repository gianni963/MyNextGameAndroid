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
import be.bxl.formation.mynextgame.models.Game


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentWishList.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentWishList : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var simpleList: ListView? = null
    var countryList = arrayOf("India", "China", "australia", "Portugle", "America", "NewZealand")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater?.inflate(R.layout.fragment_wish_list, container, false)
        val listfavouriteview = view.findViewById<ListView>(R.id.searchView
        )

        // Inflate the layout for this fragment
        val gameDao = GameDao(requireContext())

        gameDao.openReadable()
        val games: List<Any> = gameDao.all

        gameDao.close()
        //val arrayAdapter: ArrayAdapter<Game> = ArrayAdapter<Game>(this, android.R.id.simpleListView, games)
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentWishList.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentWishList().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}