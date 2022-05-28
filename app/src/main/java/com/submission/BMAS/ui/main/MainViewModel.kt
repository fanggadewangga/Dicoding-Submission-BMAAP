package com.submission.BMAS.ui.main

import android.content.Context
import android.content.res.TypedArray
import androidx.lifecycle.ViewModel
import com.submission.BMAS.R
import com.submission.BMAS.adapter.FruitAdapter
import com.submission.BMAS.model.Fruit

class MainViewModel : ViewModel() {

    private fun getFruitData(context: Context): ArrayList<Fruit>{

        val listOfFruitName : Array<String> = context.resources.getStringArray(R.array.fruit_name)
        val listOfFruitScientificName : Array<String> = context.resources.getStringArray(R.array.fruit_scientific_name)
        val listOfFruitDescription : Array<String> = context.resources.getStringArray(R.array.fruit_description)
        val listOfFruitRegion : Array<String> = context.resources.getStringArray(R.array.fruit_region)
        val listOfFruitSoil : Array<String> = context.resources.getStringArray(R.array.fruit_soil_type)
        val listOfFruitTemperature : Array<String> = context.resources.getStringArray(R.array.fruit_temperature)
        val listOfFruitImage : TypedArray = context.resources.obtainTypedArray(R.array.fruit_image)

        val listOfFruits = ArrayList<Fruit>()

        for (position in listOfFruitName.indices){
            val fruit = Fruit(
                listOfFruitName[position],
                listOfFruitScientificName[position],
                listOfFruitDescription[position],
                listOfFruitRegion[position],
                listOfFruitSoil[position],
                listOfFruitTemperature[position],
                listOfFruitImage.getResourceId(position,0)
            )
            listOfFruits.add(fruit)
        }
        return listOfFruits
    }

    fun setData(adapter: FruitAdapter,context: Context){
        adapter.listFruit = getFruitData(context)
    }
}