package kr.goldenmine.inumaker24backend

import kr.goldenmine.inumaker24backend.objs.InferenceResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface InferenceServer {
    @Multipart
    @POST("/inference/")
    fun request(
        @Part image: MultipartBody.Part, // 업로드할 파일
    ): Call<InferenceResponse>
}