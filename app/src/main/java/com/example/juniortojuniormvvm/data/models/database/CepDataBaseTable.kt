package com.example.juniortojuniormvvm.data.models.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="cep_database_table")
class CepDataBaseTable {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L

    @ColumnInfo(name = "cep")
    var cep: String = String()

    @ColumnInfo(name = "logradouro")
    var logradouro = String()

    @ColumnInfo(name = "complemento")
    var complemento = String()

    @ColumnInfo(name = "bairro")
    var bairro = String()

    @ColumnInfo(name = "localidade")
    var localidade = String()

    @ColumnInfo(name = "uf")
    var uf = String()

    @ColumnInfo(name = "address")
    var address = String()
}