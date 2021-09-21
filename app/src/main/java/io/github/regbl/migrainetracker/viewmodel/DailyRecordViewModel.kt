package io.github.regbl.migrainetracker.viewmodel

import androidx.lifecycle.*
import io.github.regbl.migrainetracker.data.model.Questionnaire
import io.github.regbl.migrainetracker.repository.UserQuestionnaireRepository
import kotlinx.coroutines.launch

/**
 * ViewModel used in DailyRecordFragment
 */
class DailyRecordViewModel(private val repository: UserQuestionnaireRepository) : ViewModel() {
    val allQuestionnairesByDate: LiveData<List<Questionnaire>> = repository.allQuestionnairesByDate.asLiveData()

    fun insert(questionnaire: Questionnaire) = viewModelScope.launch {
        repository.insert(questionnaire)
    }
}