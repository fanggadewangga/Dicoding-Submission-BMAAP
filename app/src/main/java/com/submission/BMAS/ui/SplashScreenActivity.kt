package com.submission.BMAS.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.submission.BMAS.R
import com.submission.BMAS.ui.main.MainActivity
import com.submission.BMAS.util.Constanta.TIME_SPLASH

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val handler = Handler(mainLooper)

        handler.postDelayed({
            val intentToMainActivity = Intent(this, MainActivity::class.java)
            startActivity(intentToMainActivity)
            finish()
        }, TIME_SPLASH)

       supportActionBar?.hide()
    }
}