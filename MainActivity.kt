package com.example.intentdemoapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var button: Button

    // Registrar el lanzador para recibir resultados
    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val returnText = result.data?.getStringExtra("responseText") ?: ""
                Toast.makeText(this, "Respuesta: $returnText", Toast.LENGTH_LONG).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editTextMessage)
        button = findViewById(R.id.buttonSend)

        button.setOnClickListener {
            val text = editText.text.toString()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("messageText", text)

            startForResult.launch(intent)
        }
    }
}
