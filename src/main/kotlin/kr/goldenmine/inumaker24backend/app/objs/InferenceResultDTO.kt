package kr.goldenmine.inumaker24backend.objs

import java.sql.Timestamp

class InferenceResultDTO(
    val id: Long,
    val date: Timestamp,
    val token: String,
    val percent: Double,
) {
}