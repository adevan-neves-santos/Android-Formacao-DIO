package me.dio.eletriccar.data

import me.dio.eletriccar.domain.Carro

object CarFactory {
    val list = listOf<Carro>(
        Carro(
             id       = 1
            ,preco    = "R$ 300.000,00"
            ,bateria  = "300 kWh"
            ,potencia = "20cv"
            ,recarga  = "30 min"
            ,urlPhoto = "www.google.com"
            ,isFavorite = false
        ),
        Carro(
             id       = 2
            ,preco    = "R$ 200.000,00"
            ,bateria  = "300 kWh"
            ,potencia = "150cv"
            ,recarga  = "40 min"
            ,urlPhoto = "www.google.com"
            ,isFavorite = false
        )
    )
}