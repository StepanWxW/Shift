package com.example.shift.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class UserTimezone(
    @PrimaryKey(autoGenerate = true)
    val userTimezone: Long = 0,
    val offset: String,
    val description: String
)