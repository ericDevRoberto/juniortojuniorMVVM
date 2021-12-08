package com.example.juniortojuniormvvm.data.repository

import com.example.juniortojuniormvvm.data.dataSource.CepDataBaseInsertDataSource
import com.example.juniortojuniormvvm.data.models.database.CepDataBaseTable
import com.example.juniortojuniormvvm.domain.models.CepDataBaseModel
import com.example.juniortojuniormvvm.domain.repository.CepDataBaseInsertRepository

class CepDataBaseInsertRepositoryImpl(private val dataSource: CepDataBaseInsertDataSource) : CepDataBaseInsertRepository{
    override suspend fun CepDataBaseInsert(table: CepDataBaseModel) {
        val db = CepDataBaseTable()
        db.cep = table.cep
        db.address = table.address
        db.bairro = table.bairro
        db.complemento = table.complemento
        db.localidade = table.localidade
        db.logradouro = table.logradouro
        db.uf = table.uf
        dataSource.CepDataBaseInsert(db)
    }
}