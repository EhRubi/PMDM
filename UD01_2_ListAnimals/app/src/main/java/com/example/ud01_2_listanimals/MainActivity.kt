package com.example.ud01_2_listanimals

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
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
        val btnSend = findViewById<Button>(R.id.btnSend)
        btnSend.setOnClickListener{
            val spinnerAnimalType = findViewById<Spinner>(R.id.listAnimals)
            val textKindAnimals = findViewById<TextView>(R.id.textKindsAnimals)
            textKindAnimals.text = getAnimalKind(spinnerAnimalType.selectedItemId).joinToString {"\n"}
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun getAnimalKind(id : Long) = when(id){
        0L -> listOf("Chiguagua", "Pastor Alemán")
        1L -> listOf("Egipcio", "Persa")
        2L -> listOf("Mallard", "White Call")
        else -> listOf()
    }
}