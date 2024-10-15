package com.noxis.nationalfood.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    @SerialName("name") val name: String,
    @SerialName("surname") val surname: String,
)
