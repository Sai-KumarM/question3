// FruitInformationActivity.kt
package com.example.question3

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.question3.R

class FruitSelectionActivity : AppCompatActivity() {
    private lateinit var spinnerFruits: Spinner
    private lateinit var buttonShowInfo: Button
    private lateinit var textFruitInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fruit_selection_activity)

        spinnerFruits = findViewById(R.id.spinnerFruits)
        buttonShowInfo = findViewById(R.id.buttonShowInfo)
        textFruitInfo = findViewById(R.id.textFruitInfo)

        val fruits = arrayOf("Apple", "Banana", "Grapes", "Orange", "Pineapple")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, fruits)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerFruits.adapter = adapter

        buttonShowInfo.setOnClickListener {
            val selectedFruit = spinnerFruits.selectedItem.toString()
            val info = getFruitInfo(selectedFruit)
            textFruitInfo.text = info

            val resultIntent = Intent().apply {
                putExtra("result", info)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    private fun getFruitInfo(fruit: String): String {
        return when (fruit) {
            "Apple" -> "Apples are rich in fiber and vitamin C."
            "Banana" -> "Bananas are a good source of potassium and provide quick energy."
            "Grapes" -> "Grapes have a lot of antioxidants."
            "Orange" -> "Oranges are rich in Vitamin C and citric acid."
            "Pineapple" -> "Pineapples are rich in antioxidants and help boost the immune system."
            else -> ""
        }
    }
}
