package com.example.imc

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.imc.databinding.ActivityResultBinding
import java.text.DecimalFormat

class ResultActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityResultBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)


        val result = intent.getFloatExtra("EXTRA_RESULT", 0.00f)
        val decimalFormat = DecimalFormat("0.00")


        var classification = ""
        var imgPeso = binding.imageView
        classification = if (result < 17.0f) {
            imgPeso.setImageResource(R.drawable.very_underweight)
            "Muito abaixo do peso \n" + "IMC: ${decimalFormat.format(result)}"
        }else if(result <= 18.5f) {
            imgPeso.setImageResource(R.drawable.under_weight)
            "Peso Baixo \n" + "IMC: ${decimalFormat.format(result)}"
        }else if (result <= 24.9) {
            imgPeso.setImageResource(R.drawable.normal_weight)
            "Peso normal \n" + "IMC: ${decimalFormat.format(result)}"
        } else if (result <= 29.9) {
            imgPeso.setImageResource(R.drawable.overweight)
            "Sobrepeso \n" + "IMC: ${decimalFormat.format(result)}"
        } else if (result <= 34.9) {
            imgPeso.setImageResource(R.drawable.obesity)
            "Obesidade \n" + "IMC: ${decimalFormat.format(result)}"
        } else if (result <= 39.9) {
            imgPeso.setImageResource(R.drawable.severe_obesity)
            "Obesidade grave\n" + "IMC: ${decimalFormat.format(result)}"
        }else {
            imgPeso.setImageResource(R.drawable.morbid_obesity)
            "Obesidade mórbida \n" + "IMC: ${decimalFormat.format(result)}"
        }

        val tvClassification = binding.tvResult
        tvClassification.text = classification

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}