package com.noxis.network.di

import android.content.Context
import co.infinum.retromock.Retromock
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(@ApplicationContext applicationContext: Context): Retromock =
        Retromock.Builder()
            .retrofit(
                Retrofit.Builder()
                    .baseUrl("https://fakeapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            )
            .defaultBodyFactory(applicationContext.assets::open)
            .build()
}
