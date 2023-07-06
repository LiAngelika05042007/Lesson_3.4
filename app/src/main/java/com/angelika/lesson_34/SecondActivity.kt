package com.angelika.lesson_34

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class SecondActivity : AppCompatActivity() {

    private lateinit var image: ImageView

    private val galleryLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            image.setImageURI(uri)
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        image = this.findViewById(R.id.image)

        icon()


    }

    private fun icon() {
        val text = intent.getStringExtra(MainActivity.TEXT_KEY)
        if (text != null) {
            MainActivity.TEXT_KEY = text
        }
        when (text) {
            "WhatsApp", "ватсап" -> {
                image.setImageResource(R.drawable.whatsapp)
                image.setOnClickListener {
                    val phoneNumber = "996773805811"
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")
                    startActivity(intent)
                }
            }

            "YouTube", "ютуб" -> {
                image.setImageResource(R.drawable.youtube)
                image.setOnClickListener {
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/watch?v=")
                    ).apply {
                        startActivity(this)
                    }
                }
            }

            "Google", "гугл" -> {
                image.setImageResource(R.drawable.google)
                image.setOnClickListener {
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/search?q=")
                    ).apply {
                        startActivity(this)
                    }
                }
            }

            else -> {
                image.setOnClickListener {
                    galleryLauncher.launch("image/*")
                }
            }
        }
    }
}
