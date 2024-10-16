package com.noxis.nationalfood.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable




@Serializable
data class NationalFoodsTypeDto(
    @SerialName("id")
    val id: Long,

    @SerialName("name")
    val name: String
)
