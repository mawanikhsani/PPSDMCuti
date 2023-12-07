package com.example.ppsdmcuti.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.ppsdmcuti.R

class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_DURATION: Long = 5000 // Durasi splash screen dalam milidetik (5 detik)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DURATION)
    }

}