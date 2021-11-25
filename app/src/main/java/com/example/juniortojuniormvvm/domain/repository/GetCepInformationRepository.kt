package com.example.juniortojuniormvvm.domain.repository

import com.example.juniortojuniormvvm.domain.models.CepModel

interface GetCepInformationRepository {
    suspend fun getCepInformation(cep: String): CepModel
}