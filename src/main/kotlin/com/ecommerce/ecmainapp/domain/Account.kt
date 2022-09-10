package com.ecommerce.ecmainapp.domain

class Account(
    val name: String,
    val lastName: String,
    val phoneNumber: Number,
    val email: String,
    val password: String,
    val address: Address
) {
}