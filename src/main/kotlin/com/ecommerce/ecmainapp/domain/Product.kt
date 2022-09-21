package com.ecommerce.ecmainapp.domain

import com.ecommerce.ecmainapp.domain.constants.Category
import java.math.BigDecimal
import java.time.LocalDate

class Product(
    val title: String,
    val description: String,
    val images: List<String>?,
    val price: BigDecimal,
    val lastPrice: BigDecimal,
    val uploadDate: LocalDate,
    val category: Category
) {



}