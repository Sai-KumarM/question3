// MainActivity.kt
package com.example.question3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.question3.R

class MainActivity : AppCompatActivity() {
    private lateinit var buttonFruitInfo: Button
    private lateinit var buttonCalculation: Button
    private lateinit var textViewResult: TextView

    companion object {
        const val REQUEST_CODE_FRUIT = 1
        const val REQUEST_CODE_CALC = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonFruitInfo = findViewById(R.id.buttonFruitInfo)
        buttonCalculation = findViewById(R.id.buttonCalculation)
        textViewResult = findViewById(R.id.textViewResult)

        buttonFruitInfo.setOnClickListener {
            val intent = Intent(this, FruitSelectionActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_FRUIT)
        }

        buttonCalculation.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_CALC)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && data != null) {
            val result = data.getStringExtra("result")
            textViewResult.text = result
        }
    }
}
