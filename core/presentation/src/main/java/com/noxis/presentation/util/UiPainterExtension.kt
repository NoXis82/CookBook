package com.noxis.presentation.util

import com.noxis.core.domain.R
import com.noxis.domain.enum.NationalFoodsType


fun NationalFoodsType.asUiPainter(): UiPainter {
    return when (this) {
        NationalFoodsType.RUSSIAN_AND_SOVIET_FOOD -> UiPainter.PainterResource(R.drawable.s_56908506)
        NationalFoodsType.UKRAINIAN_FOOD -> UiPainter.PainterResource(R.drawable.s_56908506)
        NationalFoodsType.BELARUSIAN_FOOD -> UiPainter.PainterResource(R.drawable.s_56908506)
        NationalFoodsType.MOLDAVIAN_FOOD -> UiPainter.PainterResource(R.drawable.s_56908506)
        NationalFoodsType.TRANS_CAUCASIAN_FOOD -> UiPainter.PainterResource(R.drawable.s_56908506)
        NationalFoodsType.KAZAKH_AND_KYRGYZ_FOOD -> UiPainter.PainterResource(R.drawable.s_56908506)
        NationalFoodsType.CENTRAL_ASIAN_FOOD -> UiPainter.PainterResource(R.drawable.s_56908506)
        NationalFoodsType.BALTIC_FOOD -> UiPainter.PainterResource(R.drawable.s_56908506)
        NationalFoodsType.FINNO_UGRIC_PEOPLES_FOOD -> UiPainter.PainterResource(
            R.drawable.s_56908506
        )

        NationalFoodsType.TURKIC_SPEAK_PEOPLES_FOOD -> UiPainter.PainterResource(
            R.drawable.s_56908506
        )

        NationalFoodsType.POLAR_FOOD -> UiPainter.PainterResource(R.drawable.s_56908506)
        NationalFoodsType.MONGOLIAN_FOOD -> UiPainter.PainterResource(R.drawable.s_56908506)
        NationalFoodsType.JEWISH_FOOD -> UiPainter.PainterResource(R.drawable.s_56908506)
    }
}
