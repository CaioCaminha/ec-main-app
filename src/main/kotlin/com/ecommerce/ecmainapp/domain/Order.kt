package com.ecommerce.ecmainapp.domain

class Order(
    val products: List<Product>,
    val user: Account
) {

    init {
        val address: Address = user.address
    }
}