package com.example.juniortojuniormvvm.data.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.juniortojuniormvvm.data.models.database.CepDataBaseTable

@Dao
interface CepDataBaseDao {

    @Insert
    suspend fun insert(cepDataBaseTable: CepDataBaseTable)

    @Query("SELECT * FROM cep_database_table")
    fun getAllCeps (): List<CepDataBaseTable>

    @Query("SELECT * FROM cep_database_table WHERE cep = :cep")
    suspend fun getCep(cep :String): CepDataBaseTable

    @Query("DELETE FROM cep_database_table")
    suspend fun clearData()
}