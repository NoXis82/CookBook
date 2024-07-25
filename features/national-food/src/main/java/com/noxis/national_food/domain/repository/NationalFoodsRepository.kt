package com.noxis.national_food.domain.repository

import com.noxis.domain.utils.RepositoryError
import com.noxis.domain.utils.RequestResult
import com.noxis.national_food.domain.model.NationalFoodsType
import kotlinx.coroutines.flow.Flow

interface NationalFoodsRepository {

    fun getAllNationalFoodsType(): Flow<RequestResult<List<NationalFoodsType>, RepositoryError>>
}