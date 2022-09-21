package com.ecommerce.ecmainapp.ports.`in`.services

import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.PutObjectRequest
import com.amazonaws.services.s3.model.Region
import com.ecommerce.ecmainapp.ports.`in`.ProductControllerPortInterface
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream

import java.lang.RuntimeException
import java.util.Date


class ProductControllerService(
    val bucketName: String,
    @Autowired
    val amazonS3: AmazonS3,
    val baseUrl: String
): ProductControllerPortInterface {
    private val logger = LoggerFactory.getLogger("ProductControllerService")


    override fun uploadProductsImagesS3(files: List<MultipartFile>): List<String> {
        var imagesUrl: MutableList<String> = arrayListOf()
        try{
            for(multipartFile in files){
                val fileName: String = generateFileName(multipartFile)
                val file = convertMultipartToFile(multipartFile)
                val fileUrl: String = "$baseUrl/$fileName"
                uploadFile(file, fileName)

                logger.info("IMAGE UPLOADED TO S3 | IMAGE URL: $fileUrl")
                imagesUrl.add(fileUrl)
            }
            return imagesUrl
        }catch (ex: Exception) {
            logger.info("IMAGE COULD NOT BE UPLOADED TO S3 | ERROR MESSAGE: ${ex.message}")
            throw RuntimeException(ex.message)
        }
    }

    fun uploadFile(file: File, fileName: String){
        /*amazonS3.putObject(PutObjectRequest(bucketName, fileName, file)
            .withCannedAcl(CannedAccessControlList.PublicRead)
        )*/
        amazonS3.putObject(bucketName, fileName, file)

    }

    fun generateFileName(multipartFile: MultipartFile): String{
        return Date().time.toString() + "-" + multipartFile.originalFilename?.replace(" ", "_")
    }

    fun convertMultipartToFile(file: MultipartFile): File{
        val convFile: File = File(file.originalFilename)
        val fos: FileOutputStream = FileOutputStream(convFile)
        fos.write(file.bytes)
        fos.close()
        return convFile
    }

}