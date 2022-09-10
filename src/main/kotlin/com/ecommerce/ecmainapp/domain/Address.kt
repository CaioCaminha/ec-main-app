package com.ecommerce.ecmainapp.domain

import com.ecommerce.ecmainapp.domain.constants.AddressType

class Address(
    val zipCode: String,
    val fullName: String,
    val phoneNumber: Number,
    val streetAddress: String,
    val country: String,
    val city: String,
    val state: String,
    val type: AddressType
) {

}