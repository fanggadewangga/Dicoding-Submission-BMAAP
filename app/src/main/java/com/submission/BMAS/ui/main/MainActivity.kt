package com.submission.BMAS.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.submission.BMAS.R
import com.submission.BMAS.adapter.FruitAdapter
import com.submission.BMAS.databinding.ActivityMainBinding
import com.submission.BMAS.ui.AboutActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // rv
        val fruitAdapter = FruitAdapter()
        mainViewModel.setData(fruitAdapter, this)

        mainBinding.rv.apply {
            adapter = fruitAdapter
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}