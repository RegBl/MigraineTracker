package io.github.regbl.migrainetracker.viewmodel

import androidx.lifecycle.*
import io.github.regbl.migrainetracker.data.model.Questionnaire
import io.github.regbl.migrainetracker.repository.UserQuestionnaireRepository
import kotlinx.coroutines.launch

/**
 * ViewModel used in DailyRecordFragment
 */
class DailyRecordViewModel(private val repository: UserQuestionnaireRepository) : ViewModel() {

    private val _navigateToMainFragment: MutableLiveData<Boolean?> = MutableLiveData<Boolean?>()
    val navigateToMainFragment: LiveData<Boolean?>
        get() = _navigateToMainFragment

    val questionOneText = MutableLiveData<String>()
    var questionTwoSlider = MutableLiveData(1.0f)
    val questionThreeToggle = MutableLiveData<Boolean>()
    val questionFourText = MutableLiveData<String>()
    val questionFiveToggle = MutableLiveData<Boolean>()
    val questionSixToggle = MutableLiveData<Boolean>()
    val questionSevenToggle = MutableLiveData<Boolean>()
    val questionEightText = MutableLiveData<String>()
    val questionNineToggle = MutableLiveData<Boolean>()

    val allQuestionnairesByDate: LiveData<List<Questionnaire>> = repository.allQuestionnairesByDate.asLiveData()

    fun onSubmitQuestionnaire() {
        viewModelScope.launch {
            // assign questions to temporary variables
            // get current dateTime
        }
    }

    fun insert(questionnaire: Questionnaire) = viewModelScope.launch {
        repository.insert(questionnaire)
    }
}