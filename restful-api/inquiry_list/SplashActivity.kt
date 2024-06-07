package com.min.inquiry_list

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 1500 // 3초 후에 MainActivity로 전환
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({

            // 시간이 지난 후 MainActivity로 이동
            startActivity(Intent(this, MainActivity::class.java))
            finish() // 현재 액티비티 종료
        }, SPLASH_TIME_OUT)
    }
}