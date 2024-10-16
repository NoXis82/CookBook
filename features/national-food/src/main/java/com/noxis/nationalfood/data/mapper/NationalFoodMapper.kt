package com.noxis.nationalfood.data.mapper

import com.noxis.database.entity.NationalFoodsTypeEntity
import com.noxis.nationalfood.data.model.NationalFoodsTypeDto
import com.noxis.nationalfood.domain.model.NationalFoodsTypeModel

fun NationalFoodsTypeEntity.toMapNationalFoodsTypeModel(): NationalFoodsTypeModel {
    return NationalFoodsTypeModel(
        this.id,
        this.name
    )
}

fun NationalFoodsTypeDto.toMapNationalFoodsTypeModel(): NationalFoodsTypeEntity {
    return NationalFoodsTypeEntity(
        this.id,
        this.name
    )
}
