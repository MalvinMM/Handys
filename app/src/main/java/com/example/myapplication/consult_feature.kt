package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class ConsultFeature : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consult_feature)
        supportActionBar?.hide()
        val searchBar = findViewById<TextInputEditText>(R.id.searchBar)
        searchBar.setOnClickListener{
            val intent = Intent(this,SearchHandyman::class.java)
            startActivity(intent)
        }

        val chatNow1 = findViewById<Button>(R.id.chatRecommended1)
        chatNow1.setOnClickListener{
            val intent = Intent(this,chat::class.java)
            startActivity(intent)
        }

        val chatNow2 = findViewById<Button>(R.id.chatRecommended2)
        chatNow2.setOnClickListener{
            val intent = Intent(this,chat::class.java)
            startActivity(intent)
        }
    }

}