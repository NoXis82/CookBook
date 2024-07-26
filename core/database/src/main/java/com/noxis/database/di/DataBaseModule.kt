package com.noxis.database.di

import android.content.Context
import androidx.room.Room
import com.noxis.database.dao.CookBookDao
import com.noxis.database.db.CookBookDataBase
import com.noxis.database.db.CookBookDataBase.Companion.MIGRATION_1_2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideCookBookDatabase(@ApplicationContext context: Context): CookBookDataBase {
        return Room.databaseBuilder(
            context,
            CookBookDataBase::class.java,
            CookBookDataBase.DB_NAME
        )
            //.addMigrations(MIGRATION_1_2)
            .allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun provideCookBookDao(cookBookDatabase: CookBookDataBase): CookBookDao {
        return cookBookDatabase.cookBookDao()
    }

}
