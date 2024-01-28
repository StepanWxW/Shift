package com.example.shift.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class UserLogin(
    @PrimaryKey(autoGenerate = true)
    val userLoginId: Long = 0,
    val uuid: String,
    val username: String,
    val password: String,
    val salt: String,
    val md5: String,
    val sha1: String,
    val sha256: String
)