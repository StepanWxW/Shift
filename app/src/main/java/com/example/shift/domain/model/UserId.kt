package com.example.shift.domain.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class UserId(
    @PrimaryKey(autoGenerate = true)
    val userIdId: Long = 0,
    @ColumnInfo(name = "id_name")
    val name: String,
    @ColumnInfo(name = "user_value")
    val value: String? = null
)