package com.noxis.nationalfood.domain.repository

import com.noxis.domain.utils.RepositoryError
import com.noxis.domain.utils.RequestResult
import com.noxis.nationalfood.domain.model.NationalFoodsType
import kotlinx.coroutines.flow.Flow

interface NationalFoodsRepository {

    fun getAllNationalFoodsType(): Flow<RequestResult<List<NationalFoodsType>, RepositoryError>>
}