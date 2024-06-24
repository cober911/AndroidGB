package com.example.app

import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
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
        enableEdgeToEdge()
        setContentView(binding.root)

        // Максимальная длина текста
        val maxLength = 40
        // Фильтр для строки ввода Имени
        val filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
        binding.nameUserInput.filters = filters

        // Добавляем TextWatcher к TextInputEditText
        binding.nameUserInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val currentLength = s?.length ?: 0
                val helperText = "$currentLength/$maxLength"
//              Далее  .helperText аналогичен setHelperText который понимает в java что это вспомогательный текст
                binding.nameUser.helperText = helperText
            }

            override fun afterTextChanged(s: Editable?) {}
        })


    }
}

