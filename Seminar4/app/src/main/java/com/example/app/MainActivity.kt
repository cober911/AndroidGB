package com.example.app

import android.content.Intent
import android.os.Bundle
import android.os.Message
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

private const val NONE = -1

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        val radioGroup = binding.radioGroup
        radioGroup.setOnCheckedChangeListener { _, buttonId ->
            when (buttonId) {
                R.id.radioButton1 -> showSnackbar("Один")
                R.id.radioButton2 -> showSnackbar("Два")
                R.id.radioButton3 -> showSnackbar("Три")
                R.id.radioButton4 -> showSnackbar("Четыре")
                NONE -> showSnackbar("Ничего")
            }
        }
        binding.button.setOnClickListener {
            radioGroup.clearCheck()
        }
        binding.buttonOpenEditTextActivity.setOnClickListener {
            val intent = Intent(this, EditTextActivity::class.java)
            startActivity(intent)
        }
    }
    private fun showSnackbar(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }
}