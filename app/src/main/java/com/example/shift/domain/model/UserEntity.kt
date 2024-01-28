package com.example.shift.domain.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    val userEntityId: Long,
    val gender: String,
    @Embedded
    val name: UserName,
    @Embedded
    val location: UserLocation,
    val email: String,
    @Embedded
    val login: UserLogin,
    @Embedded
    val dob: UserDOB,
    @Embedded
    val registered: UserRegistered,
    val phone: String,
    val cell: String,
    @Embedded
    val id: UserId,
    @Embedded
    val picture: UserProfilePicture,
    val nat: String,
)