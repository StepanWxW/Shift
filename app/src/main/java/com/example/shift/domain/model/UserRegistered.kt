package com.example.shift.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class UserRegistered(
    @PrimaryKey(autoGenerate = true)
    val userRegisteredId: Long = 0,
    @ColumnInfo(name = "registered_date")
    val date: String,
    @ColumnInfo(name = "registered_age")
    val age: Int
)