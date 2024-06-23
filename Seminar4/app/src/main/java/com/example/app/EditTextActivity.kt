package com.example.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.app.databinding.ActivityEditTextBinding


class EditTextActivity: AppCompatActivity() {
    private lateinit var binding: ActivityEditTextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditTextBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.buttonOpenEditTextActivity2.setOnClickListener {
            val intent = Intent(this, TextInputLayoutActivity::class.java)
            startActivity(intent)
        }

        val loginButton = findViewById<Button>(R.id.button_login)

        loginButton.setOnClickListener {
            if (binding.email.text.isNotBlank() && binding.password.text.isNotBlank()){
                Toast.makeText(this,"Успешно",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Ошибка", Toast.LENGTH_SHORT).show()
            }
        }
    }
}