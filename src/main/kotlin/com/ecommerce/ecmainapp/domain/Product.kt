package com.ecommerce.ecmainapp.domain

import com.ecommerce.ecmainapp.domain.constants.Category
import org.springframework.web.multipart.MultipartFile
import java.math.BigDecimal
import java.time.LocalDate

class Product(
    val title: String,
    val description: String,
    val images: List<MultipartFile>,
    val price: BigDecimal,
    val lastPrice: BigDecimal,
    val uploadDate: LocalDate,
    val category: Category
) {



}