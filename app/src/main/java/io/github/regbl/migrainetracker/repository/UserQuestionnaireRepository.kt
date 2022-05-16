package io.github.regbl.migrainetracker.repository

import io.github.regbl.migrainetracker.data.model.Questionnaire
import io.github.regbl.migrainetracker.data.QuestionnaireDao
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent

class UserQuestionnaireRepository(private val questionnaireDao: QuestionnaireDao) : KoinComponent {
    val allQuestionnairesByDate: Flow<List<Questionnaire>> = questionnaireDao.getQuestionnairesByDate()

    suspend fun insert(questionnaire: Questionnaire) {
        questionnaireDao.insertQuestionnaire(questionnaire)
    }

    fun search(query: String): Flow<List<Questionnaire>> = questionnaireDao.search(query)
}