package io.github.regbl.migrainetracker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainFragmentViewModel : ViewModel() {

    private val _navigateToDailyRecordEntry: MutableLiveData<Boolean?> = MutableLiveData<Boolean?>()
    val navigateToDailyRecordEntry: LiveData<Boolean?>
        get() = _navigateToDailyRecordEntry
}