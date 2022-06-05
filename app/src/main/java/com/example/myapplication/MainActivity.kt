package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var emailForm : EditText
    private lateinit var passwordForm : EditText
    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        supportActionBar?.hide()

        emailForm=findViewById<EditText>(R.id.editTextTextEmailAddress)
        passwordForm=findViewById<EditText>(R.id.editTextTextPassword)
        mAuth = FirebaseAuth.getInstance()

        val buttonToLanding = findViewById<Button>(R.id.sign_in_button)

        buttonToLanding.setOnClickListener{
            val email = emailForm.text.toString()
            val password = passwordForm.text.toString()

            login(email, password)
        }

        val registerNow = findViewById<TextView>(R.id.register_now_txt)
        registerNow.setOnClickListener{
            val intent = Intent(this, Register::class.java )
            startActivity(intent)
        }
    }

    private fun login(email:String, password:String){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    val intent = Intent(this,Landing::class.java)
                    finish()
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "Cannot Input", Toast.LENGTH_SHORT).show()
                }
            }
    }

}