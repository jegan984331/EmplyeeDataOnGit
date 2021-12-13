package com.example.emplyeedata

import androidx.lifecycle.LiveData

class EmplyeeRepository(private val emplyeeDao: EmplyeeDao) {

    val allEmplyee: LiveData<List<Emplyee>> = emplyeeDao.getAllEmplyee()

    suspend fun insert(emplyee: Emplyee) {
        emplyeeDao.insert(emplyee)
    }

    suspend fun update(emplyee: Emplyee) {
        emplyeeDao.update(emplyee)
    }

    suspend fun delete(emplyee: Emplyee) {
        emplyeeDao.delete(emplyee)
    }
}