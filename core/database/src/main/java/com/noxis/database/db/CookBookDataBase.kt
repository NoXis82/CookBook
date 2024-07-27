package com.noxis.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.noxis.database.dao.CookBookDao
import com.noxis.database.entity.NationalFoodsTypeEntity

class CookBookDataBase internal constructor(private val database: CookBookRoomDataBase) {
    val cookBookDao: CookBookDao
        get() = database.cookBookDao()
}

@Database(entities = [NationalFoodsTypeEntity::class], version = 1)
internal abstract class CookBookRoomDataBase : RoomDatabase() {
    abstract fun cookBookDao(): CookBookDao

    companion object {
        const val DB_NAME = "cookbook_db"
    }
}
