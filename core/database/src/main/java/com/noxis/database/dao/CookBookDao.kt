package com.noxis.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.noxis.database.entity.NationalFoodsTypeDBO

@Dao
interface CookBookDao : BaseDao<NationalFoodsTypeDBO> {

    @Query("DELETE FROM national_foods_type")
    suspend fun clearAll()

    @Query("SELECT * FROM national_foods_type")
    suspend fun getAllNationalFoodsType(): List<NationalFoodsTypeDBO>
}
