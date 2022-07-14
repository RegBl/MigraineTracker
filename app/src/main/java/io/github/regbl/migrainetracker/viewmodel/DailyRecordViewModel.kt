package io.github.regbl.migrainetracker.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import io.github.regbl.migrainetracker.data.model.Questionnaire
import io.github.regbl.migrainetracker.repository.UserQuestionnaireRepository
import io.github.regbl.migrainetracker.utility.getDateTimeNowString
import io.github.regbl.migrainetracker.view.DailyRecordFragmentArgs
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

    @RequiresApi(Build.VERSION_CODES.O)
    fun onSubmitQuestionnaire() {

        val tempQ1 = questionOneText.value ?: ""
        val tempQ2 = questionTwoSlider.value ?: 1.0f
        val tempQ3 = questionThreeToggle.value ?: false
        val tempQ4 = questionFourText.value ?: ""
        val tempQ5 = questionFiveToggle.value ?: false
        val tempQ6 = questionSixToggle.value ?: false
        val tempQ7 = questionSevenToggle.value ?: false
        val tempQ8 = questionEightText.value ?: ""
        val tempQ9 = questionNineToggle.value ?: false

        insert(
            Questionnaire(
                1,
                tempQ1,
                tempQ2.toString(),
                tempQ3.toString(),
                tempQ4,
                tempQ5.toString(),
                tempQ6.toString(),
                tempQ7.toString(),
                tempQ8,
                tempQ9.toString(),
                getDateTimeNowString()
            )
        )
        _navigateToMainFragment.value = true
    }

    /*
     * Takes an id, displays a blank questionnaire if the id=-1, otherwise displays the questionnaire with the id
     */
    fun setupQuestionnaire(id: Int) {
        if (id == -1) {
            questionOneText.value = ""
            questionTwoSlider.value = 1.0f
            questionThreeToggle.value = false
            questionFourText.value = ""
            questionFiveToggle.value = false
            questionSixToggle.value = false
            questionSevenToggle.value = false
            questionEightText.value = ""
            questionNineToggle.value = false
        } else {
            viewModelScope.launch {
                val questionnaire = repository.getQuestionnaire(id).asLiveData().value
                if (questionnaire != null) {
                    questionOneText.value = questionnaire.questionOne
                    questionTwoSlider.value = questionnaire.questionTwo?.toFloat() ?: 1.0f
                    questionThreeToggle.value = questionnaire.questionThree.toBoolean()
                    questionFourText.value = questionnaire.questionFour
                    questionFiveToggle.value = questionnaire.questionFive.toBoolean()
                    questionSixToggle.value = questionnaire.questionSix.toBoolean()
                    questionSevenToggle.value = questionnaire.questionSeven.toBoolean()
                    questionEightText.value = questionnaire.questionEight
                    questionNineToggle.value = questionnaire.questionNine.toBoolean()
                }
            }
        }
    }

    private fun insert(questionnaire: Questionnaire) = viewModelScope.launch {
        repository.insert(questionnaire)
    }

    fun doneNavigating() {
        _navigateToMainFragment.value = null
    }
}