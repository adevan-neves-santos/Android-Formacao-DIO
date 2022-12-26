package me.dio.eletriccar.data.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class CarsDbHelper(context: Context) : SQLiteOpenHelper(context,DATABASE_NAME) {

    override fun onCreate(p0: SQLiteDatabase?) {
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    companion object{
        const val DATABASE_NAME = "DbCar.db"
    }
}