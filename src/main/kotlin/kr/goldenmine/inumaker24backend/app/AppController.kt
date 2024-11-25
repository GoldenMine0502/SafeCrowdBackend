package kr.goldenmine.inumaker24backend.controller

import jakarta.servlet.http.HttpServletRequest
import kr.goldenmine.inumaker24backend.InferenceService
import kr.goldenmine.inumaker24backend.objs.AllResponse
import kr.goldenmine.inumaker24backend.objs.InferenceRequest
import kr.goldenmine.inumaker24backend.objs.InferenceResponse
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("app")
class AppController(
    private val inferenceService: InferenceService,
) {
    @PostMapping("inference")
    fun inference(
        requestServlet: HttpServletRequest,
        @RequestPart("image") file: MultipartFile,
        @RequestBody request: InferenceRequest,
    ): InferenceResponse {
        val result = inferenceService.inference(request.token, file)

        return result
    }

    @PostMapping("all")
    fun all(
        requestServlet: HttpServletRequest,
    ): AllResponse {
        return AllResponse(
            inferenceService.all()
        )
    }
}