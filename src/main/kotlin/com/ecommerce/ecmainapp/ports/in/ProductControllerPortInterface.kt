package com.ecommerce.ecmainapp.ports.`in`

import org.springframework.web.multipart.MultipartFile

interface ProductControllerPortInterface {
    fun uploadProductsImagesS3(files: List<MultipartFile>): List<String>
}