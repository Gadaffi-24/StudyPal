package com.example.quizzymcquizface

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("score", 0)
        val scoreText: TextView = findViewById(R.id.scoreText)
        val reviewButton: Button = findViewById(R.id.reviewButton)
        val exitButton: Button = findViewById(R.id.exitButton)

        // Display the score
        scoreText.text = "Your Score: $score"

        reviewButton.setOnClickListener {
            // Navigate to Review screen
        }

        exitButton.setOnClickListener {
            finish()
        }
    }
}
