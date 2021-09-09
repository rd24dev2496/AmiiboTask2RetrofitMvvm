package com.example.amiibotask2retrofitmvvmlivedata.view
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.amiibotask2retrofitmvvmlivedata.MainActivity
import com.example.amiibotask2retrofitmvvmlivedata.R


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(Runnable {
            startActivity(Intent(this@SplashActivity,
                MainActivity::class.java))
            finish()
        }, 1000)

    }
}