package com.noxis.nationalfood.data.repository

import com.noxis.database.dao.CookBookDao
import com.noxis.domain.utils.RepositoryError
import com.noxis.domain.utils.RequestResult
import com.noxis.nationalfood.domain.model.NationalFoodsTypeModel
import com.noxis.nationalfood.domain.repository.NationalFoodsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NationalFoodsRepositoryImpl(
    private val cookBookDao: CookBookDao
) : NationalFoodsRepository {

    override fun getAllNationalFoodsType(): Flow<RequestResult<List<NationalFoodsTypeModel>, RepositoryError>> {
        return flow {
            val items = cookBookDao.getAllNationalFoodsType()
            TODO()
        }
    }
}
