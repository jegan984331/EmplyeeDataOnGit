package com.example.emplyeedata


import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface EmplyeeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(emplyee: Emplyee)

    @Delete
    suspend fun delete(emplyee: Emplyee)

    @Update
    suspend fun update(emplyee: Emplyee)


    @Query("Select * from emplyeeTable order by id ASC")
    fun getAllEmplyee(): LiveData<List<Emplyee>>


}
