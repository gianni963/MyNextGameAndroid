package be.bxl.formation.mynextgame.fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import be.bxl.formation.mynextgame.MainActivity
import be.bxl.formation.mynextgame.R
import be.bxl.formation.mynextgame.RegisterUser
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_register_user.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentRegisterLogin.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentLogin : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val view : View = inflater.inflate(R.layout.fragment_login, container, false)
        // Inflate the layout for this fragment
        val registerButton =  view.findViewById<TextView>(R.id.register)
        registerButton.setOnClickListener{
            val intent = Intent(getActivity(), RegisterUser::class.java)
            startActivity(intent)
        }
        //User fill in  the form and click login button
        val loginButton =  view.findViewById<TextView>(R.id.signIn)

        loginButton.setOnClickListener{
            when {
                //check if user fill in email field
                TextUtils.isEmpty(email.text.toString().trim { it <= ' '})-> {
                    Toast.makeText(
                        getActivity(),
                        "Please enter an email",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                //check if user fill in password field
                TextUtils.isEmpty(password.text.toString().trim { it <= ' '})-> {
                    Toast.makeText(
                        getActivity(),
                        "Please enter a password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val email: String = email.text.toString().trim {it <= ' '}
                    val password: String = password.text.toString().trim {it <= ' '}

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                            if(task.isSuccessful) {
                                val firebaseUser: FirebaseUser = task.result!!.user!!

                                Toast.makeText(getActivity(), "Welcome", Toast.LENGTH_SHORT
                                ).show()

                                //send register user to main actitvity
                                val intent = Intent(getActivity(), MainActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK  or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("user_id",FirebaseAuth.getInstance().currentUser!!.uid)
                                intent.putExtra("email_id", email)
                                //start a new activity and close the others
                                startActivity(intent)
                                //finish current activity
                                getActivity()?.finishAffinity();
                            }else{
                                Toast.makeText(
                                    getActivity(),
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                }
            }
        }

        //User press logout
        val logoutButton =  view.findViewById<TextView>(R.id.logout)
        logoutButton.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            Toast.makeText(getActivity(), "You are signed out", Toast.LENGTH_SHORT
            ).show()
            val intent = Intent(getActivity(), MainActivity::class.java)
            startActivity(intent)

            getActivity()?.finishAffinity();
        }

        return view

    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentRegisterLogin.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentLogin().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}