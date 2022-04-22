package io.github.regbl.migrainetracker.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.regbl.migrainetracker.data.model.Questionnaire
import io.github.regbl.migrainetracker.repository.UserQuestionnaireRepository
import kotlinx.coroutines.launch
import java.time.LocalDateTime.now

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

        // assign questions to temporary variables
        val tempQ1 = questionOneText.value ?: ""
        val tempQ2 = questionTwoSlider.value ?: 1.0f
        val tempQ3 = questionThreeToggle.value ?: false
        val tempQ4 = questionFourText.value ?: ""
        val tempQ5 = questionFiveToggle.value ?: false
        val tempQ6 = questionSixToggle.value ?: false
        val tempQ7 = questionSevenToggle.value ?: false
        val tempQ8 = questionEightText.value ?: ""
        val tempQ9 = questionNineToggle.value ?: false

        // get current dateTime as String
        val dateTime = now().toString()

        // create Questionnaire object from temporary variables and call insert()
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
                dateTime
            )
        )
        _navigateToMainFragment.value = true
    }

    fun insert(questionnaire: Questionnaire) = viewModelScope.launch {
        repository.insert(questionnaire)
    }

    fun doneNavigating() {
        _navigateToMainFragment.value = null
    }
}