package com.example.seminar2dz

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_view, this, true)

        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)

        // Здесь можно задать начальные значения или оставить те, что в XML
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.CustomView)
            try {
                textView1.text = typedArray.getString(R.styleable.CustomView_customText1) ?: "Default text 1"
                textView2.text = typedArray.getString(R.styleable.CustomView_customText2) ?: "Default text 2"
            } finally {
                typedArray.recycle()
            }
        }
    }

    fun setTextView1(text: String) {
        textView1.text = text
    }

    fun setTextView2(text: String) {
        textView2.text = text
    }
}