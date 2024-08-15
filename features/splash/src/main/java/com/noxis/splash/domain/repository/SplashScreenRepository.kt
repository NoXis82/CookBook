package com.noxis.splash.domain.repository

import com.noxis.domain.utils.RepositoryError
import com.noxis.domain.utils.RequestResult
import kotlinx.coroutines.flow.Flow

interface SplashScreenRepository {

    fun checkInitCookBookDataBase(): Flow<RequestResult<Boolean, RepositoryError>>

    fun setAllNationalFoodsType(): Flow<RequestResult<Boolean, RepositoryError>>

}
