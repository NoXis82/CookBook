package com.noxis.database.di

import android.content.Context
import androidx.room.Room
import com.noxis.database.dao.CookBookDao
import com.noxis.database.db.CookBookDataBase
import com.noxis.database.db.CookBookRoomDataBase
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
        val ss = Room.databaseBuilder(
            context,
            CookBookRoomDataBase::class.java,
            CookBookRoomDataBase.DB_NAME
        )
            .allowMainThreadQueries()
            .build()

        return CookBookDataBase(ss)
    }

    @Singleton
    @Provides
    fun provideCookBookDao(cookBookDatabase: CookBookDataBase): CookBookDao {
        return cookBookDatabase.cookBookDao
    }

}
