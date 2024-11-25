package com.example.ud01_practica_conversormoneda

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val conversionRate = 1.12
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val euroText = findViewById<EditText>(R.id.cantEuros)
        val dolarView = findViewById<TextView>(R.id.cantDolares)
        val convertButton = findViewById<Button>(R.id.btnConver)

        convertButton.setOnClickListener{
            val eurosText = euroText.text.toString()

            if (eurosText.isNotEmpty()){
                val euros = eurosText.toDouble()

                val dolares = euros * conversionRate

                dolarView.text = String.format("%.2f Dólares", dolares)
            }else{
                dolarView.text = "Por favor, introduce una cantidad en euros."
            }
        }
    }
}
