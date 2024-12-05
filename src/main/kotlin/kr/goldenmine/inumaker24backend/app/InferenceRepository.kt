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
        ORDER BY 
            CASE WHEN res.percent = 0 THEN 1 ELSE 0 END, 
            res.percent,
            res.token ASC
    """)
    fun getRecentInferenceResultByToken(): List<InferenceResult>
}