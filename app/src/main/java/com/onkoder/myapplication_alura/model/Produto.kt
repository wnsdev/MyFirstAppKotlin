package com.onkoder.myapplication_alura.model

import java.math.BigDecimal

data class Produto (
    val nome: String,
    val descricao: String,
    val valor: BigDecimal
)