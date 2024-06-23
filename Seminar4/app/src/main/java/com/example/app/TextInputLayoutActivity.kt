package com.example.app

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.example.app.databinding.ActivityEditTextBinding
import com.example.app.databinding.ActivityInputLayoutBinding

class TextInputLayoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOpenEditTextActivity3.setOnClickListener {
            val intent = Intent(this, TextInputLayoutActivity::class.java)
            startActivity(intent)
        }

    }

    private fun isEmailValid(email: CharSequence?): Boolean {
        return !email.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}