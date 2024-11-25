package kr.goldenmine.inumaker24backend.app.objs

import java.sql.Timestamp

class InferenceResultDTO(
    val id: Long,
    val date: Timestamp,
    val token: String,
    val percent: Double,
) {
}