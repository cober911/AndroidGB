package com.example.seminar2

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.AnimationSet
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.airbnb.lottie.LottieAnimationView
import com.example.seminar2.databinding.ActivityMainBinding
import com.google.android.material.progressindicator.LinearProgressIndicator
import java.time.Duration
import java.util.Objects
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lottieView = binding.lottieView
        val progressIndicator = binding.progress
        val button = binding.Button1

        button.setOnClickListener {
            lottieView.playAnimation()
        }
        lottieView.addAnimatorUpdateListener {
            progressIndicator.progress = ((it.animatedValue as Float) * 100).roundToInt()
            Log.d("LOTTIE", "${it.animatedValue}")
        }

//        (AnimatorInflater.loadAnimator(this, R.animator.custom_animation3) as ObjectAnimator)
//            .apply {
//                target= binding.Batton1
//            }.start()
//        (AnimatorInflater.loadAnimator(this, R.animator.custom_animation_all) as AnimatorSet)
//            .apply { setTarget(binding.Batton1)}.start()

    }

}
