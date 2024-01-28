package com.example.shift.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserDOB(
    @PrimaryKey(autoGenerate = true)
    val userDobId: Long = 0,
    @ColumnInfo(name = "dob_date")
    val date: String,
    @ColumnInfo(name = "dob_age")
    val age: Int
)