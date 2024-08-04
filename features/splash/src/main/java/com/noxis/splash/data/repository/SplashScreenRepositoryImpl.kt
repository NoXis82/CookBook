package com.noxis.splash.data.repository

import com.noxis.database.dao.CookBookDao
import com.noxis.domain.utils.RepositoryError
import com.noxis.domain.utils.RequestResult
import com.noxis.splash.domain.repository.SplashScreenRepository
import kotlinx.coroutines.flow.Flow

class SplashScreenRepositoryImpl(
    private val cookBookDao: CookBookDao
): SplashScreenRepository {

    override fun checkInitCookBookDataBase(): Flow<RequestResult<Boolean, RepositoryError>> {
        TODO("Not yet implemented")
    }

    override fun setAllNationalFoodsType(): Flow<RequestResult<List<Int>, RepositoryError>> {
        TODO("Not yet implemented")
    }

}
