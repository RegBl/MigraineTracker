package io.github.regbl.migrainetracker.viewmodels

import androidx.lifecycle.*
import io.github.regbl.migrainetracker.data.Questionnaire
import io.github.regbl.migrainetracker.data.UserQuestionnaireRepository
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

class DailyRecordViewModelFactory(private val repository: UserQuestionnaireRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DailyRecordViewModel::class.java)) {
            return DailyRecordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}