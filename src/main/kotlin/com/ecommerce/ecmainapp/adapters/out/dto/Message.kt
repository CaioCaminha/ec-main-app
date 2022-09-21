package com.ecommerce.ecmainapp.adapters.out.dto

import lombok.Data
import java.util.UUID

@Data
class Message(
    val id: UUID,
    val body: Any
) {
}