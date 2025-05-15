package com.example.assignment2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val StartButton = findViewById<Button>(R.id.StartButton)


        //Set ClickListner
        StartButton?.setOnClickListener {
            val intent = Intent( this, Main2Activity::class.java)
            startActivity(intent)
        }
    }
}