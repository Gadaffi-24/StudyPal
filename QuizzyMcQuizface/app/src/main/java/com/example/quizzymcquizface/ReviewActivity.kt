package com.example.quizzymcquizface

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        // Retrieve the score passed from the previous activity
        val score = intent.getIntExtra("score", 0)

        val feedbackText: TextView = findViewById(R.id.feedbackText)
        val exitButton: Button = findViewById(R.id.exitButton1)

        // Determines the feedback message based on the user's score
        val feedback = when {
            score == 5 -> "Perfect! You nailed every question." // Score of 5 means perfect performance
            score >= 3 -> "Great job! Just a few mistakes."     // Score of 3 or more but less than 5
            score >= 2 -> "Not bad, but there's room for improvement." // Score between 2 and 3
            else -> "Looks like you need a bit more practice!" // Low score
        }

        // Score and feedback message
        feedbackText.text = "Score: $score\nFeedback: $feedback"

        // Exits app when clicked
        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}

