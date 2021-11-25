package com.example.juniortojuniormvvm.data.api

import com.example.juniortojuniormvvm.data.models.response.CepResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCepService {
    @GET("{cep_info}/json/")
    suspend fun getCepInformation(@Path("cep_info") cep: String) : CepResponse
}