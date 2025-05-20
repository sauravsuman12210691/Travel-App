package com.example.tripmate

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val email = findViewById<EditText>(R.id.emailEditTxt)
        val password = findViewById<EditText>(R.id.passwordEditTxt)
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val signer = findViewById<TextView>(R.id.signer)

        signer.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }

//        loginBtn.setOnClickListener {
//            val user = UserManager.getUserByEmail("ananya@gmail.com")
//            if(user == null){
//                email.hint = "User does not exist"
//            }else {
//                UserManager.accessToken = "aditya@gmail.com"
//                startActivity(Intent(this, MainActivity::class.java))
//                finish()
//            }
//        }

        loginBtn.setOnClickListener {
            val uEmail = email.text.toString()
            if(!uEmail.isBlank()){
                val user = UserManager.userData.find { it.email == uEmail }
                if(user != null){
                    val uPassword = password.text.toString()
                    if(user.password == uPassword){
                        UserManager.accessToken = uEmail
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else{
                        password.text.clear()
                        password.hint = "Incorrect Password"
                    }
                } else{
                    email.text.clear()
                    email.hint = "User does not exist"
                }
            } else{
                email.hint = "Email is required"
            }
        }
    }
}