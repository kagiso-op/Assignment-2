package com.example.assignment2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Main2Activity : AppCompatActivity() {

    data class Question(val text: String, val answer: Boolean)

    private val questions = listOf(
        Question("The sky is blue.", true),
        Question("Cats can fly.", false),
        Question("2 + 2 = 4.", true),
        Question("Bruno mars is white",false),
        Question("south africa has 13 continents",false)
    )

    private var currentIndex = 0
    private var score = 0
    private val userAnswers = mutableListOf<Boolean>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val questionText = findViewById<TextView>(R.id.questionText)
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)
        val nextButton = findViewById<Button>(R.id.nextButton)

        fun showQuestion() {
            feedbackText.text = ""
            questionText.text = questions[currentIndex].text
        }

        @SuppressLint("SetTextI18n")
        fun checkAnswer(userAnswer: Boolean) {
            val correct = userAnswer == questions[currentIndex].answer
            userAnswers.add(userAnswer)
            if (correct) {
                score++
                feedbackText.text = "Correct!"
            } else {
                feedbackText.text = "Incorrect"
            }
            trueButton.isEnabled = false
            falseButton.isEnabled = false
        }

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            currentIndex++
            if (currentIndex >= questions.size) {
                val intent = Intent( this, ScoreActivity3::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", questions.size)
                intent.putExtra("userAnswers", userAnswers.toBooleanArray())
                startActivity(intent)
                finish()
            } else {
                trueButton.isEnabled = true
                falseButton.isEnabled = true
                showQuestion()
            }
        }

        showQuestion()
    }
}
