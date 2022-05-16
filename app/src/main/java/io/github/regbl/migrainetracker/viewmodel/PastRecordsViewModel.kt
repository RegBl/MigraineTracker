package io.github.regbl.migrainetracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import io.github.regbl.migrainetracker.repository.UserQuestionnaireRepository

class PastRecordsViewModel(private val repository: UserQuestionnaireRepository) : ViewModel() {
    val questionnaires = repository.allQuestionnairesByDate.asLiveData()

    fun search(query: String) = repository.search(query).asLiveData()
}