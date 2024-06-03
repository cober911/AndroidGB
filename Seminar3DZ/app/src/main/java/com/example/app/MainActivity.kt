package com.example.app

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // Используйте binding.root вместо R.layout.activity_main

        setupButtonAnimations()
    }

    private fun setupButtonAnimations() {
        // Создаем отдельные анимации для каждой кнопки
        val scaleUpPlay = AnimationUtils.loadAnimation(this, R.anim.scale_up)
        val scaleDownPlay = AnimationUtils.loadAnimation(this, R.anim.scale_down)
        setupTouchAnimation(binding.btnPlay, scaleUpPlay, scaleDownPlay)

        val scaleUpNext = AnimationUtils.loadAnimation(this, R.anim.scale_up)
        val scaleDownNext = AnimationUtils.loadAnimation(this, R.anim.scale_down)
        setupTouchAnimation(binding.btnNext, scaleUpNext, scaleDownNext)

        val scaleUpBack = AnimationUtils.loadAnimation(this, R.anim.scale_up)
        val scaleDownBack = AnimationUtils.loadAnimation(this, R.anim.scale_down)
        setupTouchAnimation(binding.btnBack, scaleUpBack, scaleDownBack)
    }

    private fun setupTouchAnimation(view: View, scaleUp: Animation, scaleDown: Animation) {
        view.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.startAnimation(scaleUp)
                    true
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    v.startAnimation(scaleDown)
                    true
                }
                else -> false
            }
        }
    }
}