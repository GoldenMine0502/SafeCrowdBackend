package kr.goldenmine.inumaker24backend

import kr.goldenmine.inumaker24backend.objs.InferenceResponse
import kr.goldenmine.inumaker24backend.objs.InferenceResult
import kr.goldenmine.inumaker24backend.objs.InferenceResultDTO
import org.apache.coyote.BadRequestException
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.sql.Timestamp
import kotlin.math.floor

@Service
class InferenceService(
    private val inferenceRepository: InferenceRepository,
) {
    val service: InferenceServer = Retrofit.Builder()
        .baseUrl("http://localhost:8002")
        .addConverterFactory(GsonConverterFactory.create())
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
        .create(InferenceServer::class.java)

    fun inference(token: String, file: MultipartFile): InferenceResponse {
        val imageBody = convertMultipartFileToMultipartBody(file)
        val result = service.request(imageBody).execute().body() ?: throw BadRequestException("Bad Request")

        val inferenceResult = InferenceResult(
            0,
            Timestamp(System.currentTimeMillis()),
            token,
            result.personPercentage
        )

        inferenceRepository.save(inferenceResult)

        return result
    }

    fun all(): List<InferenceResultDTO> {
        return inferenceRepository.getRecentInferenceResultByToken().map {
            it.toDTO()
        }
    }
}