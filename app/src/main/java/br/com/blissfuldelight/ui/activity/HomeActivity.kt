package br.com.blissfuldelight.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.blissfuldelight.R
import br.com.blissfuldelight.dao.CoffeeDao
import br.com.blissfuldelight.model.Coffee
import br.com.blissfuldelight.ui.recycler.adapter.RecyclerCoffeeAdapter

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        initializeValues()
        configCoffeeList()
    }

    private fun configCoffeeList() {
        val recyclerView = findViewById<RecyclerView>(R.id.home_coffee_list)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = RecyclerCoffeeAdapter(this)
    }

    override fun onStart() {
        super.onStart()
    }

    private fun initializeValues() {
        val location = findViewById<TextView>(R.id.home_location)
        location.text = getString(R.string.location_placeholder)
    }
}