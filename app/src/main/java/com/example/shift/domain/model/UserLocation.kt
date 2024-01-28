package com.example.shift.domain.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class UserLocation(
    @PrimaryKey(autoGenerate = true)
    val userLocationId: Long = 0,
    @Embedded(prefix = "location_")
    val street: UserStreet,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    @Embedded(prefix = "location_")
    val coordinates: UserCoordinates,
    @Embedded(prefix = "location_")
    val timezone: UserTimezone
)