package com.example.seminar1dz

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.seminar1dz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var counter = 0

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Инициализация кнопок
        binding.buttonCenter.visibility = View.INVISIBLE
        binding.buttonLeft.isEnabled = false

        binding.buttonCenter.setOnClickListener {
            resetButton(binding)
        }
        binding.buttonRight.setOnClickListener {
            rightButton(binding)
        }
        binding.buttonLeft.setOnClickListener {
            leftButton(binding)
        }
    }

    private fun resetButton(binding: ActivityMainBinding) {
        counter = 1
        binding.textCenter.setText(R.string.textCenter1)
        binding.textDown.setText(R.string.textButtonDown)
        binding.textCenter.setTextColor(Color.GREEN)
        binding.buttonCenter.visibility = View.INVISIBLE
        binding.buttonLeft.isEnabled = false
        binding.buttonRight.isEnabled = true
    }

    private fun rightButton(binding: ActivityMainBinding) {
        counter++
        var free = (50 - counter)
        binding.textDown.setText(counter.toString())
        binding.buttonLeft.isEnabled = true
        if (counter < 50){
            binding.textCenter.setTextColor(Color.BLUE)
            binding.textCenter.setText(getString(R.string.textCenter2) + " " + free.toString())
            binding.buttonCenter.visibility = View.INVISIBLE
        }else{
            binding.buttonCenter.visibility = View.VISIBLE
            binding.textCenter.setText(R.string.textCenter3)
            binding.textCenter.setTextColor(Color.RED)
        }
    }

    private fun leftButton(binding: ActivityMainBinding) {
        counter--
        var free = (50 - counter)
        if (counter > 0){
            if (counter < 50){
                binding.textCenter.setText(getString(R.string.textCenter2) + " " + free.toString())
                binding.textCenter.setTextColor(Color.BLUE)
            } else binding.textCenter.setTextColor(Color.RED)
            binding.textDown.setText(counter.toString())
        }else{
            binding.textCenter.setText(R.string.textCenter1)
            binding.buttonLeft.isEnabled = false
            binding.textDown.setText(counter.toString())
            binding.textCenter.setTextColor(Color.GREEN)
        }

    }

}

//        Для батон Сброс прописываем поля по дефолту
//        binding.buttonCenter.setOnClickListener{
//            binding.textCenter.setText(getText(R.string.textCenter1))
//            binding.textDown.setText(getText(R.string.textButtonDown))
//            binding.buttonCenter.visibility = View.INVISIBLE
//            binding.buttonLeft.isEnabled = false
//            binding.buttonRight.isEnabled = true
//            counter = 0
//        }
//        binding.buttonLeft.isEnabled = false
////        Увеличиваем значение +1
//        binding.buttonRight.setOnClickListener {
//            if (counter >= 0 && counter < 51)
//                binding.buttonLeft.isEnabled = true
//                counter++
//            if (counter >= 50)
//                binding.buttonCenter.visibility = View.VISIBLE
//                binding.textCenter.setText(getText(R.string.textCenter3))
//                binding.textCenter.setTextColor(Color.RED)
//            if (counter >= 51)
//                binding.buttonRight.isEnabled = false
//            binding.textDown.setText(counter.toString())
//        }
////        Уменьшаем значение -1
//        binding.buttonLeft.setOnClickListener {
//            if (counter > 0)
//                counter--
//            if (counter < 50)
//                binding.buttonCenter.visibility = View.INVISIBLE
//            if (counter < 51)
//                binding.buttonRight.isEnabled = true
//            if (counter == 0)
//                binding.textCenter.setText(getText(R.string.textCenter1))
//                binding.buttonLeft.isEnabled = false
//            binding.textDown.setText(counter.toString())
//        }
//    }

