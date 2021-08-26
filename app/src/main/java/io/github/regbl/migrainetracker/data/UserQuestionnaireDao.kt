package io.github.regbl.migrainetracker.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface UserQuestionnaireDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertQuestionnaire(questionnaire: Questionnaire)
}