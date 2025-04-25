package com.example.quizzymcquizface

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById(R.id.startButton)

        startButton.setOnClickListener {
            // Navigate to Flashcard Question Screen
            val intent = Intent(this, FlashcardActivity::class.java)
            startActivity(intent)
        }
    }
}
