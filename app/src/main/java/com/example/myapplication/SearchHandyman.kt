package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SearchHandyman : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_handyman)
        supportActionBar?.hide()

        val chatNow1 = findViewById<Button>(R.id.chatRecommended3)
        chatNow1.setOnClickListener{
            val intent = Intent(this,chat::class.java)
            startActivity(intent)
        }

        val chatNow2 = findViewById<Button>(R.id.chatRecommended5)
        chatNow2.setOnClickListener{
            val intent = Intent(this,chat::class.java)
            startActivity(intent)
        }

        val chatNow3 = findViewById<Button>(R.id.chatRecommended6)
        chatNow1.setOnClickListener{
            val intent = Intent(this,chat::class.java)
            startActivity(intent)
        }

        val chatNow4 = findViewById<Button>(R.id.chatRecommended7)
        chatNow2.setOnClickListener{
            val intent = Intent(this,chat::class.java)
            startActivity(intent)
        }
    }
}