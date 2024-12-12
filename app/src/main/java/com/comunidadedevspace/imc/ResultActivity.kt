package com.comunidadedevspace.imc

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = result.toString()

        var (classificacao: String, color) = when {
            result <= 18.5f -> {
                "MAGREZA" to R.color.primary_100
            }

            result > 18.5f && result <= 24.9f -> {
            "NORMAL" to R.color.primari_300
            }

            result > 25f && result <= 29.9f -> {
            "SOBREPESO" to R.color.black
            }

            result > 30f && result <= 39.9f -> {
            "OBESIDADE" to R.color.primary_200
            }

            else -> {
            "OBESIDADE GRAVE" to R.color.primary_100
            }

        }

        tvClassificacao.text = classificacao
        tvClassificacao.setTextColor(ContextCompat.getColor(this, color))



    }
}