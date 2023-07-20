package com.barreto.projectimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.barreto.projectimc.MainActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {
    private lateinit var tvResult:TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescription:TextView
    private lateinit var btnRecalculate:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result: Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0

        initComponent()
        initUI(result)
        initListerner()
    }

    private fun initListerner() {
        btnRecalculate.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initUI(result: Double) {
        tvIMC.text = result.toString()
        when(result){
            in 0.00..18.50 ->{ //Baixo pesso

                tvResult.text = getString(R.string.title_peso_baixo)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_baixo))
                tvDescription.text = getString(R.string.description_peso_baixo)

            }

            in 18.51..24.99 ->{ //Pesso normal

                tvResult.text = getString(R.string.title_peso_normal)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_normal))
                tvDescription.text = getString(R.string.description_peso_normal)

            }

            in 25.00..29.99 ->{ //Sobrepeso

                tvResult.text = getString(R.string.title_sobrepeso)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.sobrepeso))
                tvDescription.text = getString(R.string.description_sobrepeso)

            }

            in 30.00..99.00 ->{ //Obessidde

                tvResult.text = getString(R.string.title_obessidade)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.obessidade))
                tvDescription.text = getString(R.string.description_obesidade)

            }
            else ->{ //error
                tvIMC.text = getString(R.string.error)
                tvResult.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initComponent() {
        tvIMC = findViewById(R.id.tvIMC)
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }
}