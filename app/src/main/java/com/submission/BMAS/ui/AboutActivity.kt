package com.submission.BMAS.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.submission.BMAS.R
import com.submission.BMAS.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var aboutBinding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        aboutBinding = ActivityAboutBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(aboutBinding.root)

        Glide.with(this)
            .load(R.drawable.img_profile)
            .apply(RequestOptions.circleCropTransform())
            .into(aboutBinding.ivProfileImage)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = getString(R.string.my_name)
            elevation=0f
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}