package kr.goldenmine.inumaker24backend

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import org.springframework.web.multipart.MultipartFile

fun convertMultipartFileToMultipartBody(file: MultipartFile): MultipartBody.Part {
    val fileName = file.originalFilename
    val requestBody = RequestBody.create(file.contentType?.toMediaTypeOrNull(), file.bytes)
    val imageBody = MultipartBody.Part.createFormData("image", fileName, requestBody)

    return imageBody
}