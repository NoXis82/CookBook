package com.noxis.nationalfood.data.mapper

import com.noxis.database.entity.NationalFoodsTypeEntity
import com.noxis.nationalfood.domain.model.NationalFoodsTypeModel

fun NationalFoodsTypeEntity.toMapNationalFoodsTypeModel(): NationalFoodsTypeModel {
    return NationalFoodsTypeModel(
        this.id,
        this.name
    )
}
