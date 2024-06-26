package com.example.app

import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.app.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

//        ---------------Реализация Имя пользователя---------------
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

//        ---------------Реализация Телефон---------------
        binding.editTextPhoneNumber.addTextChangedListener(PhoneNumberFormattingTextWatcher())
//        ---------------Свич---------------
        val switch = binding.push
        updateCheckboxState(switch.isChecked)

        switch.setOnCheckedChangeListener { _, isChecked ->
            updateCheckboxState(isChecked)
            validate() // Проверяем валидность данных при изменении состояния push
        }
//        ---------------Прогресс бар---------------
        val randomProgress = Random.nextInt(101)
        binding.progressBar.progress = randomProgress
        binding.textView.text = "$randomProgress/100"

//        ---------------Кнопка сохранить--------------
        var btn = binding.btnSave
        btn.isEnabled = false

        val textWatcher = object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validate()
            }
            override fun afterTextChanged(s: Editable?) {}
        }
        // Добавляем TextWatcher к полям ввода
        binding.nameUserInput.addTextChangedListener(textWatcher)
        binding.editTextPhoneNumber.addTextChangedListener(textWatcher)

        // Добавляем слушатель изменений для RadioButton rbOne
        binding.rbOne.setOnCheckedChangeListener { _, _ ->
            validate() // Проверяем валидность данных при изменении RadioButton
        }

        // Добавляем слушатель изменений для RadioButton rbTwo
        binding.rbTwo.setOnCheckedChangeListener { _, _ ->
            validate() // Проверяем валидность данных при изменении RadioButton
        }

        // Добавляем слушатель изменений для CheckBox box1
        binding.box1.setOnCheckedChangeListener { _, _ ->
            validate() // Проверяем валидность данных при изменении состояния box1
        }

        // Добавляем слушатель изменений для CheckBox box2
        binding.box2.setOnCheckedChangeListener { _, _ ->
            validate() // Проверяем валидность данных при изменении состояния box2
        }
        binding.btnSave.setOnClickListener {
            Snackbar.make(binding.root, "Информация сохранена", Snackbar.LENGTH_SHORT).show()
        }

    }

    private fun updateCheckboxState(isChecked: Boolean) {
        if (isChecked) {
            binding.box1.isEnabled = true
            binding.box1.setTextAppearance(R.style.CheckBoxEnabledStyle)
            binding.box2.isEnabled = true
            binding.box2.setTextAppearance(R.style.CheckBoxEnabledStyle)
        } else {
            binding.box1.isEnabled = false
            binding.box1.setTextAppearance(R.style.CheckBoxDisabledStyle)
            binding.box2.isEnabled = false
            binding.box2.setTextAppearance(R.style.CheckBoxDisabledStyle)
        }
    }


    private fun validate() {
        val name = binding.nameUserInput.text.toString().trim().isNotEmpty()
        val phone = binding.editTextPhoneNumber.text.toString().trim().length == 14
        val gender = binding.rbOne.isChecked || binding.rbTwo.isChecked

        // Проверяем, если push включен, то хотя бы один CheckBox должен быть выбран
        val pushChecked = binding.push.isChecked
        val checkboxChecked = binding.box1.isChecked || binding.box2.isChecked

        // Проверяем все условия
        val isValid = name && phone && gender && (!pushChecked || checkboxChecked)

        // Активируем кнопку btnSave, если все условия выполнены
        binding.btnSave.isEnabled = isValid
    }


}
