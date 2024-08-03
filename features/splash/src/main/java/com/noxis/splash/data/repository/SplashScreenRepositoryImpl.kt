package com.noxis.splash.data.repository

import com.noxis.database.dao.CookBookDao
import com.noxis.database.entity.NationalFoodsTypeEntity
import com.noxis.domain.enum.NationalFoodsType
import com.noxis.domain.utils.RepositoryError
import com.noxis.domain.utils.RequestResult
import com.noxis.domain.utils.onRepositoryError
import com.noxis.splash.domain.repository.SplashScreenRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SplashScreenRepositoryImpl @Inject constructor(
    private val cookBookDao: CookBookDao
) : SplashScreenRepository {

    override fun checkInitCookBookDataBase(): Flow<RequestResult<Boolean, RepositoryError>> {
        return flow {
            try {
                val result = cookBookDao.getAllNationalFoodsType()
                emit(RequestResult.Success(result.isNotEmpty()))
            } catch (e: Exception) {
                emit(RequestResult.Error(e.onRepositoryError()))
            }
        }
    }

    override fun setAllNationalFoodsType(): Flow<RequestResult<Boolean, RepositoryError>> {
        return flow {
            try {
                val entityMap = NationalFoodsType.entries.toList().map {
                    NationalFoodsTypeEntity(
                        id = 0,
                        name = it.name
                    )
                }
                val listId = cookBookDao.insert(*entityMap.toTypedArray())
                emit(RequestResult.Success(listId.isNotEmpty()))
            } catch (e: Exception) {
                emit(RequestResult.Error(e.onRepositoryError()))
            }
        }
    }

}
