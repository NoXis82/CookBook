package com.noxis.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.noxis.database.entity.NationalFoodsTypeEntity

@Dao
interface CookBookDao : BaseDao<NationalFoodsTypeEntity> {

    @Query("DELETE FROM national_foods_type")
    suspend fun clearAll()

    @Query("SELECT * FROM national_foods_type")
    suspend fun getAllNationalFoodsType(): List<NationalFoodsTypeEntity>
}
