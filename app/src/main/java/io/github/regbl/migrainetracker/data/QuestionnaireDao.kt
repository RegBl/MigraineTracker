package io.github.regbl.migrainetracker.data

import androidx.room.*
import io.github.regbl.migrainetracker.data.model.Questionnaire
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionnaireDao {
    // Create
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertQuestionnaire(questionnaire: Questionnaire)

    // Read
    @Query("SELECT * FROM questionnaire_table ORDER BY dateTime")
    fun getQuestionnairesByDate(): Flow<List<Questionnaire>>

    @Query("SELECT * FROM questionnaire_table WHERE questionnaireId = :questionnaireId")
    fun getQuestionnaire(questionnaireId: Int): Flow<Questionnaire>

    // Update
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateQuestionnaire(questionnaire: Questionnaire)

    // Delete
    @Query("DELETE FROM questionnaire_table WHERE questionnaireId = :questionnaireId")
    suspend fun delete(questionnaireId: Int)

    @Query("DELETE FROM questionnaire_table")
    suspend fun deleteAll()
}