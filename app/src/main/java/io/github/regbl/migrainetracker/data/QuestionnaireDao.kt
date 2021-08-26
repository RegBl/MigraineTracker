package io.github.regbl.migrainetracker.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionnaireDao {
    @Query("SELECT * FROM questionnaire_table ORDER BY dateTime")
    fun getQuestionnairesByDate(): Flow<List<Questionnaire>>

    @Query("SELECT * FROM questionnaire_table WHERE questionnaireId = :questionnaireId")
    fun getQuestionnaire(questionnaireId: Long): Flow<Questionnaire>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertQuestionnaire(questionnaire: Questionnaire)

    @Query("DELETE FROM questionnaire_table")
    suspend fun deleteAll()
}