package com.noxis.nationalfood.presentation.state

import com.noxis.domain.utils.RepositoryError
import com.noxis.nationalfood.domain.model.NationalFoodsTypeModel

data class NationalFoodsUiState(
    val type: List<NationalFoodsTypeModel> = emptyList(),
    val error: RepositoryError? = null
)
