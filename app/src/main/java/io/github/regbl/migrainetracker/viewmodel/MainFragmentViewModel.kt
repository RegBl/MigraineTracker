package io.github.regbl.migrainetracker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainFragmentViewModel : ViewModel() {

    private val _navigateToDailyRecordEntry = MutableLiveData<Boolean?>()
    val navigateToDailyRecordEntry: LiveData<Boolean?>
        get() = _navigateToDailyRecordEntry

    fun doneNavigating() {
        _navigateToDailyRecordEntry.value = null
    }

    fun onDailyRecordClicked() {
        _navigateToDailyRecordEntry.value = true
    }
}