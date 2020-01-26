//UserInterface page, fragments with User details are here
package com.WiseBSoftware.fitapkahms

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_userinterface.*

class UserInterface: AppCompatActivity(), BlankFragment.OnFragmentInteractionListener, BlankFragment2.OnFragmentInteractionListener {

    lateinit var blankFragment: BlankFragment
    lateinit var blankFragment2: BlankFragment2

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
    //Test fragment 2
    test_button2.setOnClickListener{
            supportFragmentManager
            .beginTransaction()
            .replace(R.id.container1, blankFragment2)
            .addToBackStack(blankFragment2.toString())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
    }
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}