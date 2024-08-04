package com.noxis.splash.data.di

import com.noxis.database.db.CookBookDataBase
import com.noxis.splash.data.repository.SplashScreenRepositoryImpl
import com.noxis.splash.domain.repository.SplashScreenRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object SplashScreenModule {

    @Provides
    @Singleton
    fun provideSplashScreenRepository(db: CookBookDataBase): SplashScreenRepository {
        return SplashScreenRepositoryImpl(db.cookBookDao)
    }
}
