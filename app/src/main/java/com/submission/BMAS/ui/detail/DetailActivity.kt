package com.submission.BMAS.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.submission.BMAS.databinding.ActivityDetailBinding
import com.submission.BMAS.model.Fruit
import com.submission.BMAS.util.Constanta.EXTRA_FRUIT

class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(detailBinding.root)

        val fruit = intent.getParcelableExtra<Fruit>(EXTRA_FRUIT)

        detailBinding.apply {
            tvFruitName.text = fruit!!.name
            tvFruitScientificName.text = fruit.scientificName
            tvFruitDescription.text = fruit.description
            tvTemperature.text = "${fruit.temperature} °F"
            tvRegion.text = fruit.region
            tvSoil.text = fruit.soil
        }

        Glide.with(this)
            .load(fruit!!.fruitImage)
            .apply(RequestOptions.circleCropTransform())
            .into(detailBinding.ivFruit)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = fruit.name
            elevation=0f
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}