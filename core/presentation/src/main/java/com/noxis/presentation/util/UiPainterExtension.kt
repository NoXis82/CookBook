package com.noxis.presentation.util

import com.noxis.core.domain.R
import com.noxis.domain.enum.NationalFoodsType


fun NationalFoodsType.asUiPainter(): UiPainter {
    return when (this) {
        NationalFoodsType.RUSSIAN_AND_SOVIET_FOOD -> UiPainter.PainterResource(R.drawable.ic_rus_cook)
        NationalFoodsType.UKRAINIAN_FOOD -> UiPainter.PainterResource(R.drawable.ic_ukr_cook)
        NationalFoodsType.BELARUSIAN_FOOD -> UiPainter.PainterResource(R.drawable.ic_br_cook)
        NationalFoodsType.MOLDAVIAN_FOOD -> UiPainter.PainterResource(R.drawable.ic_md_cook)
        NationalFoodsType.TRANS_CAUCASIAN_FOOD -> UiPainter.PainterResource(R.drawable.ic_kv_cook)
        NationalFoodsType.KAZAKH_AND_KYRGYZ_FOOD -> UiPainter.PainterResource(R.drawable.ic_kz_uz_cook)
        NationalFoodsType.CENTRAL_ASIAN_FOOD -> UiPainter.PainterResource(R.drawable.ic_asian_cook)
        NationalFoodsType.BALTIC_FOOD -> UiPainter.PainterResource(R.drawable.ic_baltic_cook)
        NationalFoodsType.FINNO_UGRIC_PEOPLES_FOOD -> UiPainter.PainterResource(
            R.drawable.ic_fin_ugr_cook
        )

        NationalFoodsType.MONGOLIAN_FOOD -> UiPainter.PainterResource(R.drawable.ic_mongol_cook)
        NationalFoodsType.JEWISH_FOOD -> UiPainter.PainterResource(R.drawable.ic_jewish_cook)
    }
}
