package com.example.androidsample2

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun convert(view: View) {
        val dollarText = findViewById<EditText>(R.id.dollarText)
        val wonText = findViewById<TextView>(R.id.wonText)

        if (dollarText.text.isNotEmpty()) {
            val dollarValue = dollarText.text.toString().toDouble()
            val wonValue = dollarValue * 1500
            wonText.text = wonValue.toString()
        }
    }
}