package com.example.quizzymcquizface

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        // Receive data from Intent
        val questions = intent.getStringArrayExtra("questions") ?: arrayOf()
        val correctAnswers = intent.getBooleanArrayExtra("answers") ?: booleanArrayOf()
        val userAnswers = intent.getBooleanArrayExtra("userAnswers") ?: booleanArrayOf()
        val scoreFromIntent = intent.getIntExtra("score", -1)

        val scoreText = findViewById<TextView>(R.id.scoreText)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        // Calculate score if not passed via Intent
        val calculatedScore = if (scoreFromIntent >= 0) {
            scoreFromIntent
        } else {
            correctAnswers.indices.count { userAnswers.getOrNull(it) == correctAnswers[it] }
        }

        // Display score
        scoreText.text = "Your Score is: $calculatedScore"

        // Show feedback
        val feedback = when (calculatedScore) {
            5 -> "Perfect! You nailed every question."
            in 3..4 -> "Great job! Just a few mistakes."
            2 -> "Not bad, but there's room for improvement."
            else -> "Looks like you need a bit more practice!"
        }
        feedbackText.text = "Feedback: $feedback"

        // ImageViews stars in the layout
        val stars = listOf(
            findViewById<ImageView>(R.id.star1),
            findViewById<ImageView>(R.id.star2),
            findViewById<ImageView>(R.id.star3),
            findViewById<ImageView>(R.id.star4),
            findViewById<ImageView>(R.id.star5)
        )

        // Update the stars based on the score
        for (i in 0 until 5) {
            if (i < calculatedScore) {
                stars[i].setImageResource(android.R.drawable.btn_star_big_on) // Filled star
            } else {
                stars[i].setImageResource(android.R.drawable.menuitem_background) // Empty star
            }
        }

        // Review button
        reviewButton.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            intent.putExtra("questions", questions)
            intent.putExtra("answers", correctAnswers)
            intent.putExtra("userAnswers", userAnswers)
            startActivity(intent)
        }

        // Exit button
        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}
