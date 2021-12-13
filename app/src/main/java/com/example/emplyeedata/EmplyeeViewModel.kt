package com.example.emplyeedata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmplyeeViewModel(application: Application) : AndroidViewModel(application) {
    val allEmplyees: LiveData<List<Emplyee>>
    val repository: EmplyeeRepository

    init {
        val dao = EmplyeeDatabase.getDatabase(application).getEmplyeeDao()
        repository = EmplyeeRepository(dao)
        allEmplyees = repository.allEmplyee
    }

    fun deleteEmplyee(emplyee: Emplyee) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(emplyee)
    }

    fun updateEmplyee(emplyee: Emplyee) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(emplyee)
    }

    fun addEmplyee(emplyee: Emplyee) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(emplyee)
    }
}