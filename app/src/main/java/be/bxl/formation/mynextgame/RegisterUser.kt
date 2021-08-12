package be.bxl.formation.mynextgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register_user.*
import com.google.android.gms.tasks.OnCompleteListener

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
class RegisterUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        //User click on register
        register_user.setOnClickListener{
            when {
                //check if user fill in email field
                TextUtils.isEmpty(email.text.toString().trim { it <= ' '})-> {
                    Toast.makeText(
                        this@RegisterUser,
                        "Please enter an email",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                //check if user fill in password field
                TextUtils.isEmpty(password.text.toString().trim { it <= ' '})-> {
                    Toast.makeText(
                        this@RegisterUser,
                        "Please enter a password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val email: String = email.text.toString().trim {it <= ' '}
                    val password: String = password.text.toString().trim {it <= ' '}

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener(
                        OnCompleteListener<AuthResult> { task ->
                            if(task.isSuccessful) {
                                val firebaseUser: FirebaseUser = task.result!!.user!!

                                Toast.makeText(this@RegisterUser, "You are now registered.", Toast.LENGTH_SHORT
                                ).show()

                                //send register user to main actitvity
                                val intent = Intent(this@RegisterUser, MainActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK  or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("user_id",firebaseUser.uid)
                                intent.putExtra("email_id", email)
                                //start a new activity and close the others
                                startActivity(intent)
                                finish()
                            }else{
                                Toast.makeText(
                                    this@RegisterUser,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    )
                }
            }
        }

    }
}