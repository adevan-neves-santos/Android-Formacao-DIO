package me.dio.eletriccar

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import me.dio.eletriccar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var preco:EditText
    lateinit var kmPercorrido:EditText
    lateinit var btnCalcular:Button
    lateinit var resultado:TextView

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        setupListeners()
    }

    private fun setupView() {
        preco        = binding.etPrecoKwh
        kmPercorrido = binding.etKmPercorrido
        btnCalcular  = binding.btnCalcular
        resultado    = binding.tvResultado
    }

    private fun setupListeners() {
        btnCalcular.setOnClickListener {
            calcular()
            (this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
                kmPercorrido.windowToken, 0
            )
        }
        kmPercorrido.setOnFocusChangeListener { _, b ->
            if (!b) {
                (this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
                    kmPercorrido.windowToken, 0
                )
            }
        }
    }

    private fun calcular(){
        val preco_valor = preco.text.toString().toFloat()
        val km = kmPercorrido.text.toString().toFloat()
        val resultado_valor = preco_valor / km
        resultado.text = "Resultado : ${resultado_valor}"
    }
}