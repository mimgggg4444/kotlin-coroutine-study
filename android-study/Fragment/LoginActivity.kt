package com.daelim

import android.R
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText


class LoginActivity : AppCompatActivity() {

    private lateinit var idInput: TextInputEditText
    private lateinit var pwInput: TextInputEditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.daelim.R.layout.activity_login)

        idInput = findViewById(com.daelim.R.id.idInput)

        pwInput = findViewById(com.daelim.R.id.pwInput)
        loginButton = findViewById(com.daelim.R.id.loginButton)

        loginButton.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val id = idInput.text.toString()
        val pw = pwInput.text.toString()

        if (pw == "1234") {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("userId", id)
            }
            startActivity(intent)
        } else {
//            Toast.makeText(this, "1234입력하세요", Toast.LENGTH_SHORT).show()
            Log.d("LoginActivity", "1234입력")
        }
    }
}
