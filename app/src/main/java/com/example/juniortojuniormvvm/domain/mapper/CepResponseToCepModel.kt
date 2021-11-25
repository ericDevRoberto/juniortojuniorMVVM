package com.example.juniortojuniormvvm.domain.mapper

import com.example.juniortojuniormvvm.data.models.response.CepResponse
import com.example.juniortojuniormvvm.domain.models.CepModel

fun CepResponse.mapper() : CepModel{
    return CepModel(
        endereco = "$logradouro, $complemento, $bairro | $localidade - $uf"
    )
}