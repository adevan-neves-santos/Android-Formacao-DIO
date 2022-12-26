package me.dio.eletriccar.data.local

import android.content.ContentValues
import android.content.Context
import android.provider.BaseColumns
import android.util.Log
import me.dio.eletriccar.data.local.CarrosContract.CarEntry.COLUMN_NAME_BATERIA
import me.dio.eletriccar.data.local.CarrosContract.CarEntry.COLUMN_NAME_CAR_ID
import me.dio.eletriccar.data.local.CarrosContract.CarEntry.COLUMN_NAME_POTENCIA
import me.dio.eletriccar.data.local.CarrosContract.CarEntry.COLUMN_NAME_PRECO
import me.dio.eletriccar.data.local.CarrosContract.CarEntry.COLUMN_NAME_RECARGA
import me.dio.eletriccar.data.local.CarrosContract.CarEntry.COLUMN_NAME_URL_PHOTO
import me.dio.eletriccar.data.local.CarrosContract.CarEntry.TABLE_NAME
import me.dio.eletriccar.domain.Carro

class CarRepository(private val context: Context) {
    fun save(carro: Carro) : Boolean {
        var isSaved = false
        try {
            val dbHelper = CarsDbHelper(context)
            val db = dbHelper.writableDatabase

            val values = ContentValues().apply {
                put(COLUMN_NAME_CAR_ID,carro.id)
                put(COLUMN_NAME_PRECO,carro.preco)
                put(COLUMN_NAME_BATERIA,carro.bateria)
                put(COLUMN_NAME_POTENCIA,carro.potencia)
                put(COLUMN_NAME_RECARGA,carro.recarga)
                put(COLUMN_NAME_URL_PHOTO,carro.urlPhoto)
            }

            val inserted = db?.insert(
                 TABLE_NAME
                ,null
                ,values
            )

            if(inserted!=null){
                isSaved = true
            }
        } catch (ex:java.lang.Exception){
            ex.message?.let {
                Log.e("Erro ao inserir -> ",it)
            }
        }
        return false
    }
    fun findCarById(id:Int) : Carro{
        val dbHelper = CarsDbHelper(context)
        val db = dbHelper.readableDatabase
        // Listam as colunas a serem exibidas no resultado da Query
        val columns = arrayOf(
             BaseColumns._ID
            ,COLUMN_NAME_CAR_ID
            ,COLUMN_NAME_PRECO
            ,COLUMN_NAME_BATERIA
            ,COLUMN_NAME_POTENCIA
            ,COLUMN_NAME_RECARGA
            ,COLUMN_NAME_URL_PHOTO
        )
        val filter = "$COLUMN_NAME_CAR_ID = ?"
        val filterValues = arrayOf(id.toString())
        val cursor = db.query(
             TABLE_NAME   //Nome da tabela
            ,columns      //As colunas a serem exibidas
            ,filter       //Where (filtro)
            ,filterValues //Valor do where, substituindo o parâmetro ?
            ,null
            ,null
            ,null
        )

        var itemId : Long = 0L
        var preco  :String = ""
        var bateria :String = ""
        var potencia : String = ""
        var recarga : String = ""
        var urlPhoto : String = ""

        with(cursor){
            while (moveToNext()){
                itemId = getLong(
                    getColumnIndexOrThrow(COLUMN_NAME_CAR_ID)
                )
                Log.d("ID -->",itemId.toString())
                preco = getString(
                    getColumnIndexOrThrow(COLUMN_NAME_PRECO)
                )
                Log.d("preço -->",preco)
                bateria = getString(
                    getColumnIndexOrThrow(COLUMN_NAME_BATERIA)
                )
                Log.d("bateria -->",bateria)
                potencia = getString(
                    getColumnIndexOrThrow(COLUMN_NAME_POTENCIA)
                )
                Log.d("potência -->",potencia)
                recarga = getString(
                    getColumnIndexOrThrow(COLUMN_NAME_RECARGA)
                )
                Log.d("recarga -->",recarga)
                urlPhoto = getString(
                    getColumnIndexOrThrow(COLUMN_NAME_URL_PHOTO)
                )
                Log.d("urlPhoto -->",urlPhoto)
            }
        }
        cursor.close()
        return  Carro(
             id = itemId.toInt()
            ,preco = preco
            ,bateria = bateria
            ,potencia = potencia
            ,recarga = recarga
            ,urlPhoto = urlPhoto
            ,isFavorite = true
        )
    }
    fun saveIfNotExists(carro: Carro){
        val car = findCarById(carro.id)
        if(car.id == ID_WHEN_NO_CAR){
            save(carro)
        }
    }
    fun getAll():List<Carro>{
        val dbHelper = CarsDbHelper(context)
        val db = dbHelper.readableDatabase
        // Listam as colunas a serem exibidas no resultado da Query
        val columns = arrayOf(
            BaseColumns._ID
            ,COLUMN_NAME_CAR_ID
            ,COLUMN_NAME_PRECO
            ,COLUMN_NAME_BATERIA
            ,COLUMN_NAME_POTENCIA
            ,COLUMN_NAME_RECARGA
            ,COLUMN_NAME_URL_PHOTO
        )

        val cursor = db.query(
            TABLE_NAME   //Nome da tabela
            ,columns      //As colunas a serem exibidas
            ,null       //Where (filtro)
            ,null //Valor do where, substituindo o parâmetro ?
            ,null
            ,null
            ,null
        )

        val carros = mutableListOf<Carro>()

        var itemId : Long = 0L
        var preco  :String = ""
        var bateria :String = ""
        var potencia : String = ""
        var recarga : String = ""
        var urlPhoto : String = ""

        with(cursor){
            while (moveToNext()){
                val itemId = getLong(
                    getColumnIndexOrThrow(COLUMN_NAME_CAR_ID)
                )
                Log.d("ID -->",itemId.toString())
                val preco = getString(
                    getColumnIndexOrThrow(COLUMN_NAME_PRECO)
                )
                Log.d("preço -->",preco)
                val bateria = getString(
                    getColumnIndexOrThrow(COLUMN_NAME_BATERIA)
                )
                Log.d("bateria -->",bateria)
                val potencia = getString(
                    getColumnIndexOrThrow(COLUMN_NAME_POTENCIA)
                )
                Log.d("potência -->",potencia)
                val recarga = getString(
                    getColumnIndexOrThrow(COLUMN_NAME_RECARGA)
                )
                Log.d("recarga -->",recarga)
                val urlPhoto = getString(
                    getColumnIndexOrThrow(COLUMN_NAME_URL_PHOTO)
                )
                Log.d("urlPhoto -->",urlPhoto)
                carros.add(
                    Carro(
                        id = itemId.toInt()
                        ,preco = preco
                        ,bateria = bateria
                        ,potencia = potencia
                        ,recarga = recarga
                        ,urlPhoto = urlPhoto
                        ,isFavorite = true
                    )
                )
            }
        }
        cursor.close()
        return carros
    }
    fun delete(id:Int){
        val dbHelper = CarsDbHelper(context)
        val db = dbHelper.writableDatabase
        db.delete(TABLE_NAME,"$COLUMN_NAME_CAR_ID = ?", arrayOf(id.toString()))
        Log.d("Database Delete","Deletando carro com ID $id")
    }
    companion object {
        const val ID_WHEN_NO_CAR = 0
    }
}