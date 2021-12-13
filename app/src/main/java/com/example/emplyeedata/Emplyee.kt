package com.example.emplyeedata


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "emplyeeTable")

class Emplyee(
    @ColumnInfo(name = "name") val emplyeeName: String,
    @ColumnInfo(name = "age") val emplyeeAge: String,
    @ColumnInfo(name = "code") val emplyeeCode: String,
    @ColumnInfo(name = "designation") val emplyeeDesignation: String
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
