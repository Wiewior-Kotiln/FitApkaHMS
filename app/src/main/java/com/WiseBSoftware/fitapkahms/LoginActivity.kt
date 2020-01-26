package com.WiseBSoftware.fitapkahms

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity: AppCompatActivity(){

    //Important info why there is auth not the FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        lateinit var auth: FirebaseAuth
        auth = FirebaseAuth.getInstance()
        //Login on Login button click
        button_login.setOnClickListener{
            //checking if data is entered properly
            val email = email_login.text.toString()
            val password = password_login.text.toString()
            if (email.isEmpty()|| password.isEmpty()){
                Toast.makeText(this, "Please enter registration details", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            //login in action
            auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this){ task ->
                    //ifLogin is Successfull go to UI fragments page
                    if (task.isSuccessful) {
                        Toast.makeText(this, "User logged in succesfully", Toast.LENGTH_SHORT)
                            .show()
                        val goIn = Intent(this, UserInterface::class.java)
                        startActivity(goIn)
                    //ifLogin is notSuccessfull display a error message
                    } else{

                    // done here should be something that will make the user proceed to the user panel instantly after he
                    //he registers the account
                    //done Step 2: make a new activity for user panel
                    //Step 3: try to download data from the datebase and display it on the user panel interface
                    //Step 4: hms all the way XD
                        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()

                }

        }
        //Go back to registration page
        goBackToRegistration_login.setOnClickListener{
            val goBack = Intent(this, MainActivity::class.java)
            startActivity(goBack)
        }
    }

}}