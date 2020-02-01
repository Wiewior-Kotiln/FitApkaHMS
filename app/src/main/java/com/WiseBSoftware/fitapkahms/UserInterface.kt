//UserInterface page, fragments with User details are here
package com.WiseBSoftware.fitapkahms

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.IgnoreExtraProperties
import kotlinx.android.synthetic.main.activity_userinterface.*

class UserInterface: AppCompatActivity(), BlankFragment.OnFragmentInteractionListener, BlankFragment2.OnFragmentInteractionListener {
    lateinit var blankFragment: BlankFragment
    lateinit var blankFragment2: BlankFragment2

// ...
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userinterface)

    blankFragment = BlankFragment.newInstance()
    blankFragment2 = BlankFragment2.newInstance()
    //Test fragment 1
    test_button.setOnClickListener{
            supportFragmentManager
            .beginTransaction()
            .replace(R.id.container1, blankFragment)
            .addToBackStack(blankFragment.toString())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()

    }

    test_button2.setOnClickListener{
        //swaping fragment and updating useEmail address
        val newUserEmail = testemail.text.toString()
            supportFragmentManager
            .beginTransaction()
            .replace(R.id.container1, blankFragment2)
            .addToBackStack(blankFragment2.toString())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
            emailUpdate(newUserEmail)
    }
    test_button3.setOnClickListener{
        //calling the getUserData function to obtain email address and uid of the currently logged in User
            getUserData()

    }

    }
    // getUserData function, made it just to check whether the emailUpdate is working
    private fun getUserData(){

        val user = FirebaseAuth.getInstance().currentUser
        user?.let{
            val email = user.email
            val uid = user.uid
            Toast.makeText(this,email+uid,Toast.LENGTH_SHORT).show()
        }
    }
    //email update function
    private fun emailUpdate(newEmail: String){
        val user = FirebaseAuth.getInstance().currentUser
        user?.updateEmail(newEmail)?.addOnCompleteListener{task->
            if (task.isSuccessful){
                Toast.makeText(this,"No i sie udało mordko gitarka jest XD", Toast.LENGTH_SHORT).show()
            }
            else { Toast.makeText(this,"Coś poszło nie tak :<", Toast.LENGTH_SHORT).show()}
        }
    }
    //There should be some more functions which will allow user to:
    //Logout onClick
    //Update DateBase with user input saved under the uid of the currently logged User
    //The nextStep is to install any ML kit which will enable the app to identify the objects and save
    //names and data of this object eg.( apple: color, size:small,medium,large )to the record in the datebase
    //identified with uid

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}