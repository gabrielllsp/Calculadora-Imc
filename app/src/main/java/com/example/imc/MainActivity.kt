package com.example.imc

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val btnCalculate = binding.btnCalculate
        val btnDelete = binding.btnDelete
        var edtWeight = binding.textInputWeight.text
        var edtHeight = binding.textInputHeight.text


        btnCalculate.setOnClickListener {

            if (edtWeight.isNullOrBlank() || edtHeight.isNullOrBlank()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            } else {
                val heightConverter: Float = edtHeight.toString().toFloat()
                val sumHeight = heightConverter * heightConverter
                val weightConverter: Float = edtWeight.toString().toFloat()
                var result: Float = weightConverter / sumHeight


                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            }
        }

        btnDelete.setOnClickListener {
            val clearHeight = edtHeight?.clear()
            clearHeight.toString()

            val clearWeight = edtWeight?.clear()
            clearWeight.toString()
        }
    }
}