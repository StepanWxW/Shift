package com.example.shift.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class UserProfilePicture(
    @PrimaryKey(autoGenerate = true)
    val userProfileId: Long = 0,
    val large: String,
    val medium: String,
    val thumbnail: String
)