package com.example.tinerpets.fragmentsNavMenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.tinerpets.R
import com.example.tinerpets.ViewAdapter

class CreatePetActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter: ViewAdapter
    lateinit var imageList: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_pet)

        // initializing variables
        // of below line with their id.
        viewPager = findViewById(R.id.idViewPager)

        // on below line we are initializing
        // our image list and adding data to it.
        imageList = ArrayList<Int>()
        imageList = imageList + R.drawable.cat1
        imageList = imageList + R.drawable.cat2
        imageList = imageList + R.drawable.ic_menu_home
        imageList = imageList + R.drawable.icon_pet_logo

        // on below line we are initializing our view
        // pager adapter and adding image list to it.
        viewPagerAdapter = ViewAdapter(this, imageList)

        // on below line we are setting
        // adapter to our view pager.
        viewPager.adapter = viewPagerAdapter
    }
}