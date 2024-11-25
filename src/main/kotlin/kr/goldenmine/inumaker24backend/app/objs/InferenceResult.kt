package kr.goldenmine.inumaker24backend.objs

import jakarta.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "inference_result")
class InferenceResult(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "date")
    val date: Timestamp,

    @Column(name = "token")
    val token: String,

    @Column(name = "percent")
    val percent: Double,
    ) {
    fun toDTO(): InferenceResultDTO {
        return InferenceResultDTO(
            id = id,
            date = date,
            token = token,
            percent = percent,
        )
    }
}