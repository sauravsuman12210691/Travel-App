package com.example.tripmate

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = findViewById<EditText>(R.id.nameEditTxt)
        val email = findViewById<EditText>(R.id.emailEditTxt)
        val password = findViewById<EditText>(R.id.passwordEditTxt)
        val cPassword = findViewById<EditText>(R.id.cPasswordEditTxt)
        val signupBtn = findViewById<Button>(R.id.signupBtn)
        val logger = findViewById<TextView>(R.id.logger)

        logger.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }

        signupBtn.setOnClickListener {
            val uName = name.text.toString()
            val uEmail = email.text.toString()
            val uPassword = password.text.toString()
            val uCPassword = cPassword.text.toString()

            if(!uName.isEmpty()){
                if(!uEmail.isEmpty()){
                    if(!uPassword.isEmpty()){
                        if(uPassword == uCPassword){
                            UserManager.userData.add(User(uName, uEmail, uPassword, null, null, null, null, null, null, null))
                            startActivity(Intent(this, Login::class.java))
                            finish()
                            name.text.clear()
                            email.text.clear()
                            password.text.clear()
                            cPassword.text.clear()
                        } else{
                            cPassword.text.clear()
                            cPassword.hint = "Password does not match"
                        }
                    }else{
                        password.hint = "Password is required"
                    }
                } else{
                    email.hint = "Email is required"
                }
            } else{
                name.hint = "Name is required"
            }
        }

    }
}