package io.github.regbl.migrainetracker.viewmodel

import androidx.lifecycle.ViewModel
import io.github.regbl.migrainetracker.data.model.Questionnaire

class QuestionnaireViewModel(questionnaire: Questionnaire) {
    val date = questionnaire.dateTime
    val id = questionnaire.questionnaireId.toString()
    val intensity = questionnaire.questionTwo ?: ""
}