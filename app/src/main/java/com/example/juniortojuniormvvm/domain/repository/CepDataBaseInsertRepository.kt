package com.example.juniortojuniormvvm.domain.repository

import com.example.juniortojuniormvvm.domain.models.CepDataBaseModel

interface CepDataBaseInsertRepository {
    suspend fun CepDataBaseInsert(table: CepDataBaseModel)
}