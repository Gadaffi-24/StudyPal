package com.example.quizzymcquizface

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FlashcardActivity : AppCompatActivity() {

    //Question array
    private val questions = arrayOf(
        "Nelson Mandela was South Africa’s first Black president.",
        "Table Mountain is one of the oldest mountains in the world.",
        "The South African flag has exactly five colors.",
        "The discovery of gold in Johannesburg led to the city’s rapid growth.",
        "Desmond Tutu was known as the 'Archbishop of Peace and Laughter.'"
    )

    //Answers array
    private val answers = booleanArrayOf(true, true, false, true, true)
    private var userAnswers = BooleanArray(questions.size) // Store user answers
    private var score = 0
    private var currentQuestionIndex = 0

    private lateinit var questionText: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard)

        // Initialize views
        questionText = findViewById(R.id.questionText)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)

        // Show the first question
        showQuestion()

        // Handle true/false button clicks
        trueButton.setOnClickListener {
            handleAnswer(true)
        }

        falseButton.setOnClickListener {
            handleAnswer(false)
        }

        // Handle the "Next" button click
        nextButton.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                showQuestion()
                enableAnswerButtons()
            } else {
                // Once the user finishes all the questions, send data to ScoreActivity
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("questions", questions)
                intent.putExtra("answers", answers)
                intent.putExtra("userAnswers", userAnswers)
                startActivity(intent)
                finish()  // Close the current activity after launching the ScoreActivity
            }
        }
    }

    // Show the current question to the user
    private fun showQuestion() {
        questionText.text = questions[currentQuestionIndex]
    }

    // Handle answer selection (True/False)
    private fun handleAnswer(userAnswer: Boolean) {
        userAnswers[currentQuestionIndex] = userAnswer // Store the user's answers
        val correctAnswer = answers[currentQuestionIndex]
        if (userAnswer == correctAnswer) {
            score++ // Increase score if answer is correct
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
        }
        disableAnswerButtons() // Disables the answer buttons after the user selects an answer
    }

    // Disables the answer buttons after a selection
    private fun disableAnswerButtons() {
        trueButton.isEnabled = false
        falseButton.isEnabled = false
    }

    // Enables the answer buttons for the next question
    private fun enableAnswerButtons() {
        trueButton.isEnabled = true
        falseButton.isEnabled = true
    }
}
