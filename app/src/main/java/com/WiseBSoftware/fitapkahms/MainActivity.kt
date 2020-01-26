package com.WiseBSoftware.fitapkahms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val auth = FirebaseAuth.getInstance()

        //registration button action
        button_registration.setOnClickListener{
            //declaring the login values and checking if they are entered properly
            val email = email_registration.text.toString()
            val password = password_registration.text.toString()
            if (email.isEmpty()|| password.isEmpty()){
                Toast.makeText(this, "Please enter registration details", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //Adding user to the datebase
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (!task.isSuccessful) {
                        Toast.makeText(this, "User creation process failed", Toast.LENGTH_SHORT).show()
                        return@addOnCompleteListener}
                    //else if succesfull
                    Toast.makeText(this, "User created succesfully", Toast.LENGTH_SHORT).show()

                }
                .addOnFailureListener{
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
        }
        //alreadyHaveAnAccount action > Go to login Page
        alreadyHaveAnAccount_registration.setOnClickListener{
            //val goBack = Intent(this, LoginActivity::class.java)
           // startActivity(goBack)
           val goBack = Intent(this, LoginActivity::class.java)
            startActivity(goBack)
        }




    }
}
