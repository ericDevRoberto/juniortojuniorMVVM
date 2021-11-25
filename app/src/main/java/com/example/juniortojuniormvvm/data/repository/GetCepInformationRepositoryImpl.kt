package com.example.juniortojuniormvvm.data.repository

import com.example.juniortojuniormvvm.data.dataSource.GetCepInformationDataSource
import com.example.juniortojuniormvvm.domain.mapper.mapper
import com.example.juniortojuniormvvm.domain.models.CepModel
import com.example.juniortojuniormvvm.domain.repository.GetCepInformationRepository

class GetCepInformationRepositoryImpl(private val dataSource: GetCepInformationDataSource) :
    GetCepInformationRepository {

    override suspend fun getCepInformation(cep: String): CepModel {
        return dataSource.getCepInformation(cep).mapper()
    }

}