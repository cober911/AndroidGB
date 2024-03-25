package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var counter = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainText1.setText(getString(R.string.testText))
//        binding.mainText1.isAllCaps = true // не работает
        binding.buttonIMG1.setOnClickListener {
            if (counter == 5) {
                binding.button1.visibility = View.VISIBLE
                counter = 0
            }
            else {
                binding.button1.visibility = View.INVISIBLE
                counter++
            }
            binding.mainText1.setText(counter.toString())
        }


        binding.button1.setOnClickListener { // Блокируем нажатие кнопки +1 при нажатии на button1
            binding.buttonIMG1.isEnabled = false
        }

    }
}