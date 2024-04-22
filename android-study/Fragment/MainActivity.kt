package com.daelim


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var homeBtn: TextView
    private lateinit var homeName: TextView
    private lateinit var btn1: Button
    private lateinit var btn2: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeName = findViewById(R.id.home_name)

        val userId = intent.getStringExtra("userId")
        homeName.text = userId
        homeBtn = findViewById(R.id.home_btn)
        btn1 = findViewById(R.id.button)
        btn2 = findViewById(R.id.button2)

        // 예시로 HomeFragment를 화면에 표시

        btn1.setOnClickListener {
            replaceFragment(HomeFragment())
        }
        btn2.setOnClickListener {
            replaceFragment(MyFragment())
        }

    }

    fun setButtonText(text: String) {
        homeBtn.text = text
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, fragment)
            commit()
        }
    }
}

