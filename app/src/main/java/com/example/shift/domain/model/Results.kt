package com.example.shift.domain.model

import androidx.room.Embedded

data class Results(
    @Embedded
    val results: List<UserEntity>
)