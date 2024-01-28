package com.example.shift.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserCoordinates(
    @PrimaryKey(autoGenerate = true)
    val coordinatesId: Long = 0,
    val latitude: String,
    val longitude: String
)