package com.ecommerce.ecmainapp.adapters.`in`

import com.ecommerce.ecmainapp.ports.`in`.ProductControllerPortInterface
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/product/image")
class ProductControllerAdapter(
    val productControllerPort: ProductControllerPortInterface
) {

    @GetMapping()
    fun test(): String{
        return "teste"
    }

    @PostMapping
    fun uploadProductsImages(@RequestParam(name = "image") imagesMultipartFile: List<MultipartFile>/*, @RequestBody product: Product*/): ResponseEntity<Any>?{
        val imagesUrl: List<String> = productControllerPort.uploadProductsImagesS3(imagesMultipartFile)
        return ResponseEntity.ok(imagesUrl)
    }
}