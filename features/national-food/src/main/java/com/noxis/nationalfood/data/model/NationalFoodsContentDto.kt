package com.noxis.nationalfood.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NationalFoodsContentDto(
    @SerialName("content")
    val content: List<NationalFoodsTypeDto>
)
