package com.example.quizzymcquizface

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FlashcardActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994",
        "The first man on the moon was Neil Armstrong",
        "The Great Wall of China was built in the 20th century",
        "The Earth revolves around the Sun",
        "Alexander the Great was born in Greece"
    )

    private val answers = arrayOf(true, true, false, true, true)
    private var score = 0
    private var currentQuestionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard)

        val questionText: TextView = findViewById(R.id.questionText)
        val trueButton: Button = findViewById(R.id.trueButton)
        val falseButton: Button = findViewById(R.id.falseButton)
        val nextButton: Button = findViewById(R.id.nextButton)

        // Show the first question
        questionText.text = questions[currentQuestionIndex]

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                questionText.text = questions[currentQuestionIndex]
            } else {
                // Navigate to the score screen
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
            }
        }
    }

    private fun checkAnswer(answer: Boolean) {
        if (answer == answers[currentQuestionIndex]) {
            score++
        }
    }
}
