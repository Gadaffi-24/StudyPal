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

        // Score from the previous activity
        val score = intent.getIntExtra("score", 0)

        val scoreText: TextView = findViewById(R.id.scoreText)

        // ImageViews (stars) in the layout
        val stars = listOf(
            findViewById<ImageView>(R.id.star1),
            findViewById<ImageView>(R.id.star2),
            findViewById<ImageView>(R.id.star3),
            findViewById<ImageView>(R.id.star4),
            findViewById<ImageView>(R.id.star5)
        )

        // Update the stars based on the score
        for (i in 0 until 5) {
            if (i < score) {
                stars[i].setImageResource(android.R.drawable.btn_star_big_on) // Set filled star image
            } else {
                stars[i].setImageResource(android.R.drawable.menuitem_background)  // Set empty star image
            }
        }

        // Display the score label
        scoreText.text = "Your Score is: $score"

        // Review button opens the ReviewActivity
        val reviewButton: Button = findViewById(R.id.reviewButton)
        reviewButton.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
        }

        // Exit button exits the app
        val exitButton: Button = findViewById(R.id.exitButton)
        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}
