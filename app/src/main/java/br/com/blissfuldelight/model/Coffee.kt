package br.com.blissfuldelight.model

import java.math.BigDecimal

data class Coffee(
    val id: Long,
    val name: String,
    val description: String,
    val ratings: List<Double>,
    val price: BigDecimal,
    val category: Category,
    val image: String
)
