package com.submission.BMAS.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.submission.BMAS.databinding.ItemListFruitBinding
import com.submission.BMAS.model.Fruit
import com.submission.BMAS.ui.detail.DetailActivity
import com.submission.BMAS.util.Constanta.EXTRA_FRUIT

class FruitAdapter : RecyclerView.Adapter<FruitAdapter.FruitViewHolder>() {

    var listFruit = ArrayList<Fruit>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val view = ItemListFruitBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FruitViewHolder(view)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        holder.bindView(listFruit[position])
    }

    override fun getItemCount(): Int = listFruit.size

    class FruitViewHolder(private val view : ItemListFruitBinding) : RecyclerView.ViewHolder(view.root) {

        fun bindView(fruit : Fruit){
            view.apply {
                view.tvFruitName.text = fruit.name
                view.tvFruitScientificName.text = fruit.scientificName
                view.ivFruitImage.setImageResource(fruit.fruitImage)
                view.tvFruitRegion.text = fruit.region
            }

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(EXTRA_FRUIT,fruit)
                itemView.context.startActivity(intent)
            }
        }

    }
}