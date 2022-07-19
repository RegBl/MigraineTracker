package io.github.regbl.migrainetracker.viewmodel

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.regbl.migrainetracker.data.model.Questionnaire
import io.github.regbl.migrainetracker.repository.UserQuestionnaireRepository
import io.github.regbl.migrainetracker.utility.getDateTimeNowString
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

/**
 * ViewModel used in DailyRecordFragment
 */
class DailyRecordViewModel(private val repository: UserQuestionnaireRepository) : ViewModel() {

    private val _navigateToMainFragment: MutableLiveData<Boolean?> = MutableLiveData<Boolean?>()
    val navigateToMainFragment: LiveData<Boolean?>
        get() = _navigateToMainFragment

    private val _deleteButtonVisibility: MutableLiveData<Int?> = MutableLiveData<Int?>()
    val deleteButtonVisibility: LiveData<Int?>
        get() = _deleteButtonVisibility

    var buttonString = MutableLiveData<String>()
    var questionnaireId: Int = 0
    private var pastRecordDateTimeString: String? = null

    val questionOneText = MutableLiveData<String>()
    val questionTwoSlider = MutableLiveData(1.0f)
    val questionThreeToggle = MutableLiveData<Boolean>()
    val questionFourText = MutableLiveData<String>()
    val questionFiveToggle = MutableLiveData<Boolean>()
    val questionSixToggle = MutableLiveData<Boolean>()
    val questionSevenToggle = MutableLiveData<Boolean>()
    val questionEightText = MutableLiveData<String>()
    val questionNineToggle = MutableLiveData<Boolean>()

    @RequiresApi(Build.VERSION_CODES.O)
    fun onSubmitQuestionnaire() {
        when (questionnaireId) {
            0 -> insert(getCurrentQuestionnaire(0))
            else -> update(getCurrentQuestionnaire(questionnaireId))
        }
        _navigateToMainFragment.value = true
    }

    private fun getCurrentQuestionnaire(id: Int): Questionnaire {
        return Questionnaire(
            id,
            1,
            questionOneText.value ?: "",
            (questionTwoSlider.value ?: 1.0f).toString(),
            (questionThreeToggle.value ?: false).toString(),
            questionFourText.value ?: "",
            (questionFiveToggle.value ?: false).toString(),
            (questionSixToggle.value ?: false).toString(),
            (questionSevenToggle.value ?: false).toString(),
            questionEightText.value ?: "",
            (questionNineToggle.value ?: false).toString(),
            dateTime = pastRecordDateTimeString ?: getDateTimeNowString()
        )
    }

    fun onDeleteDailyRecord() = viewModelScope.launch {
        repository.delete(questionnaireId)
        _navigateToMainFragment.value = true
    }

    /*
     * Takes an id, displays a blank questionnaire if the id=-1, otherwise displays the questionnaire with the id
     */
    fun setupQuestionnaire(id: Int) {
        questionnaireId = id
        if (id == 0) {
            questionOneText.value = ""
            questionTwoSlider.value = 1.0f
            questionThreeToggle.value = false
            questionFourText.value = ""
            questionFiveToggle.value = false
            questionSixToggle.value = false
            questionSevenToggle.value = false
            questionEightText.value = ""
            questionNineToggle.value = false
            _deleteButtonVisibility.value = View.GONE
            buttonString.value = "Submit"
        } else {
            viewModelScope.launch {
                val questionnaire = repository.getQuestionnaire(id).firstOrNull()
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
                    _deleteButtonVisibility.value = View.VISIBLE
                    pastRecordDateTimeString = questionnaire.dateTime
                    buttonString.value = "Update"
                }
            }
        }
    }

    private fun insert(questionnaire: Questionnaire) = viewModelScope.launch {
        repository.insert(questionnaire)
    }

    private fun update(questionnaire: Questionnaire) = viewModelScope.launch {
        repository.update(questionnaire)
    }

    fun doneNavigating() {
        _navigateToMainFragment.value = null
    }
}