package io.github.regbl.migrainetracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import io.github.regbl.migrainetracker.data.QuestionnaireDao

class PastRecordsViewModel(val questionnaireDao: QuestionnaireDao) : ViewModel() {
    val questionnaires = questionnaireDao.getQuestionnairesByDate().asLiveData()
}