package com.example.juniortojuniormvvm.domain.userCases

import com.example.juniortojuniormvvm.domain.models.CepModel
import com.example.juniortojuniormvvm.domain.repository.GetCepInformationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCepInformationUserCase(private val repository: GetCepInformationRepository) {

    suspend operator fun invoke(cep: String): CepModel {
        return withContext(Dispatchers.IO) {
            repository.getCepInformation(cep)
        }
    }
}