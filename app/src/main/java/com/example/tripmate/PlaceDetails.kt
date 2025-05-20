package com.example.tripmate

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PlaceDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_place_details)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolBar = findViewById<Toolbar>(R.id.toolBarOne)
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        })


        val pageTitle = findViewById<TextView>(R.id.pageTitle)
        val image1 = findViewById<ImageView>(R.id.imgView1)
        val image2 = findViewById<ImageView>(R.id.imgView2)
        val image3 = findViewById<ImageView>(R.id.imgView3)
        val desc = findViewById<TextView>(R.id.descriptionText)

        val name = intent.getStringExtra("name")
        val details = intent.getStringExtra("details")
        val images : IntArray = intent.getIntArrayExtra("image") ?: intArrayOf()

        pageTitle.text = name
        image1.setImageResource(images[0])
        image2.setImageResource(images[1])
        image3.setImageResource(images[2])
        desc.text = details
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}