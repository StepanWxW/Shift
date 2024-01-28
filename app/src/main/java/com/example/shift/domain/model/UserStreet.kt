package com.example.shift.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class UserStreet(
    @PrimaryKey(autoGenerate = true)
    val userStreetId: Long = 0,
    val number: Int,
    val name: String
)