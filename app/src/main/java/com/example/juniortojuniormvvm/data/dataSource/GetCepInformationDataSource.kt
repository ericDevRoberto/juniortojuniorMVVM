package com.example.juniortojuniormvvm.data.dataSource

import com.example.juniortojuniormvvm.data.api.ApiCepService
import com.example.juniortojuniormvvm.data.models.response.CepResponse

class GetCepInformationDataSource(private val service: ApiCepService) {

    suspend fun getCepInformation(cep: String): CepResponse {
        return try {
            service.getCepInformation(cep)
        }
        catch (e: Throwable) {
            throw e
        }
    }
}