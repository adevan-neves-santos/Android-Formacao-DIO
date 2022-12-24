package me.dio.eletriccar.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import me.dio.eletriccar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var btnCalcular:Button
    lateinit var lista:ListView

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        setupListeners()
        setupList()
    }

    private fun setupView() {
        btnCalcular  = binding.btnCalcular
        lista        = binding.lvInformacoes
    }

    private fun setupList(){
        var dados = arrayOf(
            "Cupcake","Donut","Froyo","Gingerbread","Honeycomb",
            "Ice Cream Sandwich","Jelly Bean"
        )
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, dados)
        lista.adapter = adapter
    }

    private fun setupListeners() {
        btnCalcular.setOnClickListener {
            startActivity(Intent(this,CalcularAutonomiaActivity::class.java))
        }

    }


}