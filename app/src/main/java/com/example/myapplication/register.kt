package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {

    private lateinit var emailForm : EditText
    private lateinit var passwordForm : EditText
    private lateinit var mAuth : FirebaseAuth
    private lateinit var mDbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()

        emailForm=findViewById<EditText>(R.id.editTextTextEmailAddress)
        passwordForm=findViewById<EditText>(R.id.editTextTextPassword)
        mAuth = FirebaseAuth.getInstance()

        val buttonToLanding = findViewById<Button>(R.id.sign_up_button)
        buttonToLanding.setOnClickListener{

            val email = emailForm.text.toString()
            val password = passwordForm.text.toString()

            register(email, password)
        }
    }

    private fun register(email:String, password:String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    addUserToDB(email, password,mAuth.currentUser?.uid!!)
                    val intent = Intent(this,Landing::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Broken", Toast.LENGTH_SHORT).show()
                    Toast.makeText(this,"BROKEN WOI",Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun addUserToDB(email:String, password:String, uid:String){
        mDbRef=FirebaseDatabase.getInstance().getReference()
        mDbRef.child("User").child(uid).setValue(User(email,password,uid))
    }
}