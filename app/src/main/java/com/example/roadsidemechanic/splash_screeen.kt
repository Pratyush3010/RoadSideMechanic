package com.example.roadsidemechanic

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.example.roadsidemechanic.databinding.ActivitySplashScreeenBinding

class splash_screeen : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreeenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreeenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val translateanim = AnimationUtils.loadAnimation(this,R.anim.translation)
        val visibleanim = AnimationUtils.loadAnimation(this,R.anim.visibility)
        binding.splashLogo.startAnimation(visibleanim)
        binding.splashText.startAnimation(translateanim)

        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },3000)
    }
}