package com.noxis.nationalfood.domain.model

data class NationalFoodsTypeModel(
    val id: Long = ID_NONE,
    val name: String
) {
    companion object {
        /**
         * Специальный ID для обозначения что ID нету
         */
        const val ID_NONE: Long = 0L
    }
}
