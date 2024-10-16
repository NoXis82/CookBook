package com.noxis.nationalfood.data.repository

import com.noxis.database.dao.CookBookDao
import com.noxis.database.entity.NationalFoodsTypeEntity
import com.noxis.domain.utils.RepositoryError
import com.noxis.domain.utils.RequestResult
import com.noxis.domain.utils.onRepositoryError
import com.noxis.nationalfood.data.api.NationalFoodsApi
import com.noxis.nationalfood.data.mapper.toMapNationalFoodsTypeModel
import com.noxis.nationalfood.domain.model.NationalFoodsTypeModel
import com.noxis.nationalfood.domain.repository.NationalFoodsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Provider

class NationalFoodsRepositoryImpl(
    private val cookBookDao: CookBookDao,
    private val nationalFoodsApi: Provider<NationalFoodsApi>
) : NationalFoodsRepository {

    override fun getAllNationalFoodsType(): Flow<RequestResult<List<NationalFoodsTypeModel>, RepositoryError>> {
        return flow {
            try {
                if (cookBookDao.checkCountItems() == 0) {
                    //Если БД пуста делаем запрос, пишем в БД и отдаем данные
                    val items = nationalFoodsApi.get()
                        .getAllNationalFoodsType().content.map {
                            NationalFoodsTypeEntity(
                                id = it.id,
                                name = it.name
                            )
                        }

                    cookBookDao.insert(*items.toTypedArray())
                }
                val itemsEntity = cookBookDao.getAllNationalFoodsType()
                emit(RequestResult.Success(itemsEntity.map { it.toMapNationalFoodsTypeModel() }))
            } catch (e: IOException) {
                emit(RequestResult.Error(e.onRepositoryError()))
            }
        }
    }
}
