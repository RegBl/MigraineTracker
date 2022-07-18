package io.github.regbl.migrainetracker.data

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.regbl.migrainetracker.data.model.Questionnaire

@Database(
    entities = [Questionnaire::class],
    version = 2,
    exportSchema = false
)
abstract class UserQuestionnaireDatabase : RoomDatabase() {
    abstract fun questionnaireDao(): QuestionnaireDao
}