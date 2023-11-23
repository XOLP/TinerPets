package com.example.tinerpets.splashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.tinerpets.AuthActivity
import com.example.tinerpets.MainActivity
import com.example.tinerpets.R

class splashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val img : ImageView = findViewById(R.id.splashScreenLogo)
        img.alpha = 0f

        img.animate().setDuration(2000).alpha(1f).withEndAction{
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
            finish()
        }

    }
}