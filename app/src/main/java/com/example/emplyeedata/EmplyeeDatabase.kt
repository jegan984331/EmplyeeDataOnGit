package com.example.emplyeedata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Emplyee::class), version = 1, exportSchema = false)

abstract class EmplyeeDatabase : RoomDatabase() {
    abstract fun getEmplyeeDao(): EmplyeeDao

    companion object {
        @Volatile
        private var INSTANCE: EmplyeeDatabase? = null
        fun getDatabase(context: Context): EmplyeeDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EmplyeeDatabase::class.java,
                    "emplyee_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}