package com.example.tinerpets

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tinerpets.fragmentsNavMenu.ChatFragment
import com.example.tinerpets.fragmentsNavMenu.HomeFragment
import com.example.tinerpets.fragmentsNavMenu.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), UpdateStausAuth {



    private val auth = AuthenticatorRobot()


    override fun OnDataPass(data: Boolean) {
        if(data)
        {
            val intent = Intent(this, AuthActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        if(auth.Checklogin()){

        }
        else{
            val intent = Intent(this, AuthActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val profileFragment = ProfileFragment()
        val homeFragment = HomeFragment()
        val chatFragment = ChatFragment()



        val menu:BottomNavigationView =findViewById(R.id.bottom_navigation)






        if(auth.Checklogin()){

        }
        else{
            val intent = Intent(this, AuthActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

        makecurrentFragment(profileFragment)
        menu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.ic_profile -> makecurrentFragment(profileFragment)
                R.id.ic_home -> makecurrentFragment(homeFragment)
                R.id.ic_chat -> makecurrentFragment(chatFragment)


            }
            true
        }

    }

    private fun makecurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
        replace(R.id.fl_wrapper,fragment)
        commit()
    }

    }



