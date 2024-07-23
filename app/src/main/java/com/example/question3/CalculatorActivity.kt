// CalculationActivity.kt
package com.example.question3

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.question3.R

class CalculatorActivity : AppCompatActivity() {
    private lateinit var edtxt1: EditText
    private lateinit var edtxt2: EditText
    private lateinit var resultTV: TextView
    private lateinit var spinnerVal: Spinner
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator_activity)

        button = findViewById(R.id.btResult)
        edtxt1 = findViewById(R.id.ednum1)
        edtxt2 = findViewById(R.id.ednum2)
        resultTV = findViewById(R.id.textResult)
        spinnerVal = findViewById(R.id.spSelect)
        val options = arrayOf("sum", "subtract", "division", "multiply")

        spinnerVal.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)

        button.setOnClickListener {
            val x = edtxt1.text.toString().toInt()
            val y = edtxt2.text.toString().toInt()
            val operation = spinnerVal.selectedItem.toString()

            val result = when (operation) {
                "sum" -> sum(x, y)
                "multiply" -> multiply(x, y)
                "subtract" -> subtract(x, y)
                "division" -> division(x, y)
                else -> throw IllegalArgumentException("Incorrect")
            }

            resultTV.text = result.toString()

            val resultIntent = Intent().apply {
                putExtra("result", result.toString())
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    private fun sum(a: Int, b: Int): Int {
        return a + b
    }

    private fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    private fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    private fun division(a: Int, b: Int): Int {
        return a / b
    }
}
