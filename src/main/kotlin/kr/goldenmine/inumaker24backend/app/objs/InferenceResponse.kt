package kr.goldenmine.inumaker24backend.app.objs

import com.google.gson.annotations.SerializedName

class InferenceResponse(
    @SerializedName("output_predictions")
    val outputPredictions: List<List<Int>>, // 어차피 필요없어서 생략하고싶긴한데

    @SerializedName("person_percentage")
    val personPercentage: Double,
) {
}