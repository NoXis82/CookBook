package com.noxis.nationalfood.data.di

import co.infinum.retromock.Retromock
import com.noxis.database.db.CookBookDataBase
import com.noxis.nationalfood.data.api.NationalFoodsApi
import com.noxis.nationalfood.data.repository.NationalFoodsRepositoryImpl
import com.noxis.nationalfood.domain.repository.NationalFoodsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NationalFoodsTypeModule {

    @Provides
    @Singleton
    fun provideNationalFoodsTypeApi(retromock: Retromock): NationalFoodsApi {
        return retromock.create(NationalFoodsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNationalFoodsTypeRepository(
        db: CookBookDataBase,
        nationalFoodsApi: NationalFoodsApi
    ): NationalFoodsRepository {
        return NationalFoodsRepositoryImpl(db.cookBookDao) { nationalFoodsApi }
    }
}
