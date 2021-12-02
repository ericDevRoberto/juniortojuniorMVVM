package com.example.juniortojuniormvvm.domain.mapper

import com.example.juniortojuniormvvm.data.models.response.CepResponse
import com.example.juniortojuniormvvm.domain.models.CepModel

fun CepResponse.mapper() : CepModel{
    return CepModel(
        address = "$logradouro, $complemento, $bairro | $localidade - $uf",
        cep = cep
    )
}