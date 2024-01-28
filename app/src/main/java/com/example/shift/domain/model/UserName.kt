package com.example.shift.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserName(
    @PrimaryKey(autoGenerate = true)
    val userNameId: Long = 0,
    val title: String,
    val first: String,
    val last: String
)