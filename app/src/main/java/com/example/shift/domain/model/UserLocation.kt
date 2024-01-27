package com.example.shift.domain.model

data class UserLocation(
    val street: UserStreet,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val coordinates: UserCoordinates,
    val timezone: UserTimezone
)