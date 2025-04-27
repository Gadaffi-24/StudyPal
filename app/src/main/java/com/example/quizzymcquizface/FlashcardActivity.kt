package com.example.quizzymcquizface

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FlashcardActivity : AppCompatActivity() {

    // Array of quiz questions
    private val questions = arrayOf(
        "Nelson Mandela was South Africa’s first Black president.",
        "Table Mountain is one of the oldest mountains in the world.",
        "The South African flag has exactly five colors.",
        "The discovery of gold in Johannesburg led to the city’s rapid growth.",
        "Desmond Tutu was known as the 'Archbishop of Peace and Laughter.'"
    )

    // Answers to each question
    private val answers = arrayOf(true, true, false, true, true)

    // Score tracker
    private var score = 0

    // Tracks which question the user is on
    private var currentQuestionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard)

        val questionText: TextView = findViewById(R.id.questionText)
        val trueButton: Button = findViewById(R.id.trueButton)
        val falseButton: Button = findViewById(R.id.falseButton)
        val nextButton: Button = findViewById(R.id.nextButton)

        // Displays the questions
        questionText.text = questions[currentQuestionIndex]

        // Checks the answers the user tapped
        trueButton.setOnClickListener {
            handleUserAnswer(true, questionText)
        }

        falseButton.setOnClickListener {
            handleUserAnswer(false, questionText)
        }

        // Moves to the next question or end the quiz
        nextButton.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                // Load the next question
                questionText.text = questions[currentQuestionIndex]
            } else {
                // Launch ScoreActivity and pass the score
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
            }
        }
    }

    // Function to check user's answer and update score
    private fun handleUserAnswer(userAnswer: Boolean, questionText: TextView) {
        try {
            // Compare user's answer to the correct answer
            if (userAnswer == answers[currentQuestionIndex]) {
                score++
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            }

        } catch (e: IndexOutOfBoundsException) {
            // Handle case where index is invalid just in case something bad happens while user answers the quiz
            Toast.makeText(this, "Oops! Something went wrong with the quiz.", Toast.LENGTH_SHORT).show()
            questionText.text = "Question unavailable due to an error but be patient and retry."
        }
    }
}

