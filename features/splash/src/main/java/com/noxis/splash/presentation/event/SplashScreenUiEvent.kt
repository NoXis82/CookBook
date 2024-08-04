package com.noxis.splash.presentation.event

sealed class SplashScreenUiEvent {

    data object SetAllNationalFoodsType : SplashScreenUiEvent()
    data object CheckInitDataBase : SplashScreenUiEvent()

//    data class GetOnClickItemType(): NationalFoodsUiEvent()

}
