package kr.goldenmine.inumaker24backend.app

import kr.goldenmine.inumaker24backend.app.objs.InferenceResult
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface InferenceRepository: JpaRepository<InferenceResult, Long> {
    @Query("""
        SELECT res FROM InferenceResult res WHERE res.id IN (
            SELECT MAX(res2.id)
                FROM InferenceResult res2
                GROUP BY res2.token
        )
    """)
    fun getRecentInferenceResultByToken(): List<InferenceResult>
}