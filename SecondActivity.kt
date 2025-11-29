package com.example.intentdemoapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var textViewReceived: TextView
    private lateinit var editTextResponse: EditText
    private lateinit var buttonReturn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textViewReceived = findViewById(R.id.textViewReceived)
        editTextResponse = findViewById(R.id.editTextResponse)
        buttonReturn = findViewById(R.id.buttonReturn)

        // Recuperar texto enviado
        val receivedText = intent.getStringExtra("messageText")
        textViewReceived.text = receivedText

        buttonReturn.setOnClickListener {
            val responseText = editTextResponse.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("responseText", responseText)
            setResult(Activity.RESULT_OK, resultIntent)

            finish() // Volver a MainActivity
        }
    }
}
