package com.example.juniortojuniormvvm.data.dataSource

import com.example.juniortojuniormvvm.data.dataBase.dao.CepDataBaseDao
import com.example.juniortojuniormvvm.data.models.database.CepDataBaseTable

class CepDataBaseInsertDataSource(private val cepDataBaseDao: CepDataBaseDao) {
    suspend fun CepDataBaseInsert(table: CepDataBaseTable) = cepDataBaseDao.insert(table)
}