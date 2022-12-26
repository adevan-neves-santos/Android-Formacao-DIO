package me.dio.eletriccar.data.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import me.dio.eletriccar.data.local.CarrosContract.SQL_COMMAND_CREATE_TABLE_CAR
import me.dio.eletriccar.data.local.CarrosContract.SQL_COMMAND_DELETE_ENTRIES

class CarsDbHelper(context: Context) : SQLiteOpenHelper(context,DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_COMMAND_CREATE_TABLE_CAR)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_COMMAND_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db,oldVersion,newVersion)
    }

    companion object{
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "DbCar.db"
    }
}