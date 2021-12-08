package com.example.juniortojuniormvvm.data.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.juniortojuniormvvm.data.dataBase.dao.CepDataBaseDao
import com.example.juniortojuniormvvm.data.models.database.CepDataBaseTable


@Database(entities = [CepDataBaseTable::class], version = 1, exportSchema = false)
abstract class DataBase: RoomDatabase() {
    abstract val cepDataBaseDao : CepDataBaseDao
}