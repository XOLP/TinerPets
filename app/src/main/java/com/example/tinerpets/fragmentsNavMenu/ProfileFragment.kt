package com.example.tinerpets.fragmentsNavMenu

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Context
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.tinerpets.CatData
import com.example.tinerpets.DogData
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
        val selimg : ImageView = view.findViewById(R.id.selectedImage)




        val changeImage =
            registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ) {
                if (it.resultCode == Activity.RESULT_OK) {
                    val data = it.data
                    val imgUri = data?.data
                    selimg.setImageURI(imgUri)
                }
            }

        //val btbSelectImage: Button = view.findViewById(R.id.btn_image_pet_selector)
        selimg.setOnClickListener(){
            val pickImg = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            changeImage.launch(pickImg)



        }
        return view
    }
    //
    fun catCreate() :CatData {
        TODO()

    }
    fun dogCreate() :DogData {
        TODO()
    }



}