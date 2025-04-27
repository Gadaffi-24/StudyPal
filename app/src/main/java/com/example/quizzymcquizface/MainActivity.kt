package com.example.quizzymcquizface

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            setContentView(R.layout.activity_main)

            // Apply waving animation to welcome message
            val waveAnimation = AnimationUtils.loadAnimation(this, R.anim.wave)
            val welcomeText = findViewById<TextView>(R.id.welcomeMessage)
            welcomeText.startAnimation(waveAnimation)

            // Start button along with a click listener
            val startButton: Button = findViewById(R.id.startButton)
            startButton.setOnClickListener {
                // Navigate to Flashcard Question Screen
                val intent = Intent(this, FlashcardActivity::class.java)
                startActivity(intent)
            }
        } catch (e: Exception) {
            // Log the error and display a user-friendly message
            Log.e("MainActivity", "Error in onCreate", e)
            Toast.makeText(this, "Something went wrong. Don't forget to visit again.", Toast.LENGTH_LONG).show()
        }
    }
}
