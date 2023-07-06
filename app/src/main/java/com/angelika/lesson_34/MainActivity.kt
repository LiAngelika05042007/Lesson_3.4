package com.angelika.lesson_34

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var etInputText: EditText
    private lateinit var btnTransition: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etInputText = this.findViewById(R.id.et_input_text)
        btnTransition = this.findViewById(R.id.btn_transition)

        transition()
    }

    private fun transition() {
        btnTransition.setOnClickListener {
            val text = etInputText.text.toString().trim()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(TEXT_KEY, text)
            startActivity(intent)
        }
    }

    companion object {
        var TEXT_KEY = "text"
    }
}