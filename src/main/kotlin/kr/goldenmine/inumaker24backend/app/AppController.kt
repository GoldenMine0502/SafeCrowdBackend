package kr.goldenmine.inumaker24backend.app

import jakarta.servlet.http.HttpServletRequest
import kr.goldenmine.inumaker24backend.app.objs.AllResponse
import kr.goldenmine.inumaker24backend.app.objs.InferenceResponse
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("")
class AppController(
    private val inferenceService: InferenceService,
) {
    @PostMapping("inference")
    fun inference(
        requestServlet: HttpServletRequest,
        @RequestPart("token") token: String,
        @RequestPart("image") image: MultipartFile,
    ): InferenceResponse {
        val result = inferenceService.inference(token, image)

        return result
    }

    @GetMapping("all")
    fun all(
        requestServlet: HttpServletRequest,
    ): AllResponse {
        return AllResponse(
            inferenceService.all()
        )
    }
}