package io.github.regbl.migrainetracker.data

import kotlinx.coroutines.flow.Flow

class UserQuestionnaireRepository(private val questionnaireDao: QuestionnaireDao) {
    val allQuestionnairesByDate: Flow<List<Questionnaire>> = questionnaireDao.getQuestionnairesByDate()

    suspend fun insert(questionnaire: Questionnaire) {
        questionnaireDao.insertQuestionnaire(questionnaire)
    }
}