package com.example.assignment2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ScoreActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId" , "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score3)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        val scoreText = findViewById<TextView>(R.id.scoreText)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        scoreText.text = "Your Score: $score / $total"

        feedbackText.text = when {
            score >= total * 0.8 -> "Excellent job!"
            score >= total * 0.5 -> "Good effort!"
            else -> "Keep practicing!"
        }

        reviewButton.setOnClickListener {
            val review = StringBuilder()
            val answers = intent.getBooleanArrayExtra("userAnswers")!!
            val sampleQuestions = listOf(
                "The sky is blue.",
                "Cats can fly.",
                "2 + 2 = 4."
            )
            for (i in answers.indices) {
                review.append("Q${i+1}: ${sampleQuestions[i]}\n")
                review.append("Your Answer: ${if (answers[i]) "True" else "False"}\n")
                review.append("Correct Answer: ${if (i != 1) "True" else "False"}\n\n")
            }
            feedbackText.text = review.toString()
        }

        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}

