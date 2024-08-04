package com.noxis.splash.presentation.viewmodel

import com.noxis.presentation.viewmodel.StateAndEventViewModel
import com.noxis.splash.domain.repository.SplashScreenRepository
import com.noxis.splash.presentation.event.SplashScreenUiEvent
import com.noxis.splash.presentation.state.SplashScreenUiState
import javax.inject.Inject

class SplashScreenViewModel @Inject constructor(
    private val splashScreenRepository: SplashScreenRepository
) : StateAndEventViewModel<SplashScreenUiState, SplashScreenUiEvent>(
    SplashScreenUiState()
) {
    override suspend fun handleEvent(uiEvent: SplashScreenUiEvent) {
        when (uiEvent) {
            SplashScreenUiEvent.SetAllNationalFoodsType -> TODO()
            SplashScreenUiEvent.CheckInitDataBase -> TODO()
        }
    }
}
