package me.dio.eletriccar.data

import me.dio.eletriccar.domain.Carro
import retrofit2.Call
import retrofit2.http.GET

interface CarsApi {
    @GET("cars.json")
    fun getAllCars() : Call<List<Carro>>
}