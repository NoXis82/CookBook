package com.noxis.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.noxis.database.dao.CookBookDao
import com.noxis.database.entity.NationalFoodsTypeDBO


@Database(
    entities = [NationalFoodsTypeDBO::class],
    version = 2,
    exportSchema = false
)
abstract class CookBookDataBase : RoomDatabase() {
    abstract fun cookBookDao(): CookBookDao

    companion object {
        const val DB_NAME = "cookbook_db"
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "CREATE TABLE `national_foods_type` (" +
                            "`id` INTEGER NOT NULL, " +
                            "`Name` TEXT NOT NULL, " +
                            "PRIMARY KEY(`id`))"
                )
                //todo тут надо проверить
                database.execSQL(
                    "INSERT INTO `national_foods_type` VALUES(1, 'Грузинская кухня')"
                )
            }
        }
    }
}
