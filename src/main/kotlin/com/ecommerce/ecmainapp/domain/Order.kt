package com.ecommerce.ecmainapp.domain

class Order(
    val products: List<Product>,
    val userId: String
) {

}