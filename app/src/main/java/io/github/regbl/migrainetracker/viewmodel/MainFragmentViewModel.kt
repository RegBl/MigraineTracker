package io.github.regbl.migrainetracker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainFragmentViewModel : ViewModel() {

    private val _navigateToDailyRecordEntry = MutableLiveData<Boolean?>()
    val navigateToDailyRecordEntry: LiveData<Boolean?>
        get() = _navigateToDailyRecordEntry

    private val _navigateToPastRecords = MutableLiveData<Boolean?>()
    val navigateToPastRecords: LiveData<Boolean?>
        get() = _navigateToPastRecords

    fun doneNavigating() {
        _navigateToDailyRecordEntry.value = null
        _navigateToPastRecords.value = null
    }

    fun onDailyRecordClicked() {
        _navigateToDailyRecordEntry.value = true
    }

    fun onPastRecordsClicked() {
        _navigateToPastRecords.value = true
    }
}