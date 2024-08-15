package com.noxis.nationalfood.data.di

import com.noxis.database.db.CookBookDataBase
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
    fun provideNationalFoodsTypeRepository(db: CookBookDataBase): NationalFoodsRepository {
        return NationalFoodsRepositoryImpl(db.cookBookDao)
    }
}
