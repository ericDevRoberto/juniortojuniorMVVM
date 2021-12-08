package com.example.juniortojuniormvvm.domain.userCases

import com.example.juniortojuniormvvm.domain.models.CepDataBaseModel
import com.example.juniortojuniormvvm.domain.repository.CepDataBaseInsertRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CepDataBaseInsertUseCase(private val repository: CepDataBaseInsertRepository) {
    suspend operator fun invoke(
        cep: String,
        logradouro: String,
        complemento: String,
        bairro: String,
        localidade: String,
        uf: String,
        address: String,
    ) {
        withContext(Dispatchers.IO) {
            val db = CepDataBaseModel(
                cep = cep,
                logradouro = logradouro,
                complemento = complemento,
                bairro = bairro,
                localidade = localidade,
                uf =  uf,
                address = address
            )
            repository.CepDataBaseInsert(db)
        }
    }
}