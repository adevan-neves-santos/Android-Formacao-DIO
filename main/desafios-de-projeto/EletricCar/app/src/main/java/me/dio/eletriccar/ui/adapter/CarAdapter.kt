package me.dio.eletriccar.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.dio.eletriccar.R
import me.dio.eletriccar.domain.Carro

class CarAdapter(private val carros: List<Carro>) :
    RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    // Cria uma nova View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.carro_item,parent,false)
        return ViewHolder(view)
    }

    // Pega o conteúdo da view e troca pela informação de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val carroItem = carros[position]
        //Desestruturado o objeto carro em seus atributos e passando ao holder
        with(carroItem){
            holder.preco.text = preco
            holder.bateria.text = bateria
            holder.potencia.text = potencia
            holder.recarga.text  = recarga
        }

    }
    // Pega a quantidade de carros da lista
    override fun getItemCount() = carros.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val preco: TextView
        val bateria: TextView
        val potencia:TextView
        val recarga: TextView
        init {
            view.run {
                preco = findViewById(R.id.tv_preco_value)
                bateria = findViewById(R.id.tv_bateria_value)
                potencia = findViewById(R.id.tv_potencia_value)
                recarga = findViewById(R.id.tv_recarga_value)
            }
        }
    }

}

