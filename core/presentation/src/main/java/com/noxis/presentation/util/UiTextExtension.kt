package com.noxis.presentation.util

import com.noxis.core.domain.R
import com.noxis.domain.enum.NationalFoodsType
import com.noxis.domain.utils.RepositoryError

fun RepositoryError.DataBaseError.asUiText(): UiText {
    return when (this) {
        RepositoryError.DataBaseError.SQLITE_ERROR -> UiText.StringResource(R.string.error_sql_database)
    }
}

fun NationalFoodsType.asUiText(): UiText {
    return when (this) {
        NationalFoodsType.RUSSIAN_AND_SOVIET_FOOD -> UiText.StringResource(R.string.russian_and_soviet_food)
        NationalFoodsType.UKRAINIAN_FOOD -> UiText.StringResource(R.string.ukrainian_food)
        NationalFoodsType.BELARUSIAN_FOOD -> UiText.StringResource(R.string.belarusian_food)
        NationalFoodsType.MOLDAVIAN_FOOD -> UiText.StringResource(R.string.moldavian_food)
        NationalFoodsType.TRANS_CAUCASIAN_FOOD -> UiText.StringResource(R.string.trans_caucasian_food)
        NationalFoodsType.KAZAKH_AND_KYRGYZ_FOOD -> UiText.StringResource(R.string.kazakh_and_kyrgyz_food)
        NationalFoodsType.CENTRAL_ASIAN_FOOD -> UiText.StringResource(R.string.central_asian_food)
        NationalFoodsType.BALTIC_FOOD -> UiText.StringResource(R.string.baltic_food)
        NationalFoodsType.FINNO_UGRIC_PEOPLES_FOOD -> UiText.StringResource(R.string.finno_ugric_peoples_food)
        NationalFoodsType.TURKIC_SPEAK_PEOPLES_FOOD -> UiText.StringResource(R.string.turkic_speack_peoples_food)
        NationalFoodsType.POLAR_FOOD -> UiText.StringResource(R.string.polar_food)
        NationalFoodsType.MONGOLIAN_FOOD -> UiText.StringResource(R.string.mongolian_food)
        NationalFoodsType.JEWISH_FOOD -> UiText.StringResource(R.string.jewish_food)
    }
}
