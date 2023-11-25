package com.example.tinerpets.fragmentsNavMenu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.tinerpets.CatData
import com.example.tinerpets.DogData
import com.example.tinerpets.MainActivity
import com.example.tinerpets.R

//


class ProfileFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)

        return view

        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnCreate: Button = view.findViewById(R.id.buttonCreatePet)
        btnCreate.setOnClickListener{
            val intent = Intent(activity, CreatePetActivity::class.java )
            startActivity(intent )
        }



    }

    //
    fun catCreate() :CatData {
        TODO()

    }
    fun dogCreate() :DogData {
        TODO()
    }



}