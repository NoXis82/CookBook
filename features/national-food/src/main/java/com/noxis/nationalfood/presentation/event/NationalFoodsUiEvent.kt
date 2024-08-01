package com.noxis.nationalfood.presentation.event

sealed class NationalFoodsUiEvent {

    data object GetAllNationalFoodsType : NationalFoodsUiEvent()

//    data class GetOnClickItemType(): NationalFoodsUiEvent()

}
