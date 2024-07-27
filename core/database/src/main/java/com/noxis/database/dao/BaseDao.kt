package com.noxis.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.RawQuery
import androidx.room.Update
import androidx.sqlite.db.SupportSQLiteQuery

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg obj: T): Array<Long>

    @Update
    fun update(vararg obj: T)

    @RawQuery
    fun findById(query: SupportSQLiteQuery): T?

    @Delete
    fun delete(obj: T)
}
