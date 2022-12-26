package me.dio.eletriccar.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import me.dio.eletriccar.R
import me.dio.eletriccar.databinding.ActivityCalcularAutonomiaBinding

class CalcularAutonomiaActivity : AppCompatActivity() {

    lateinit var preco: EditText
    lateinit var kmPercorrido:EditText
    lateinit var resultado: TextView
    lateinit var btnCalcular: Button
    lateinit var btnClose:ImageView

    private lateinit var binding:ActivityCalcularAutonomiaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalcularAutonomiaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        setupListeners()
        setupCachedResult()
    }
    private fun setupView() {
        preco        = binding.etPrecoKwh
        kmPercorrido = binding.etKmPercorrido
        btnCalcular  = binding.btnCalcular
        btnClose     = binding.ivClose
        resultado    = binding.tvResultado
    }

    private fun setupListeners() {
        btnCalcular.setOnClickListener {
            calcular()
            //Esconde o teclado do usuário
            (this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
                kmPercorrido.windowToken, 0
            )
        }
        //Perda de foco e esconde o teclado do usuário
        kmPercorrido.setOnFocusChangeListener { _, b ->
            if (!b) {
                (this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
                    kmPercorrido.windowToken, 0
                )
            }
        }
        btnClose.setOnClickListener {
            finish()
        }
    }

    private fun calcular(){
        val preco_valor = preco.text.toString().toFloat()
        val km = kmPercorrido.text.toString().toFloat()
        val resultado_valor = preco_valor / km
        resultado.text = "Resultado : ${resultado_valor}"
        saveSharedPref(resultado_valor)
    }

    private fun saveSharedPref(resultado:Float){
        val sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()){
            putFloat(getString(R.string.saved_cal),resultado)
        }
    }

    private fun getSharedPref():Float{
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        val calculo = sharedPref.getFloat(getString(R.string.saved_cal), 0F)
        return calculo
    }

    private fun setupCachedResult() {
        val valorCalculado = getSharedPref()
        resultado.text = valorCalculado.toString()
    }
}