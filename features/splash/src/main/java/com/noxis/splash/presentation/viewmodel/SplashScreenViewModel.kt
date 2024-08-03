package com.noxis.splash.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noxis.domain.utils.RequestResult
import com.noxis.splash.domain.repository.SplashScreenRepository
import com.noxis.splash.presentation.state.SplashScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val splashScreenRepository: Provider<SplashScreenRepository>
) : ViewModel() {
    var state by mutableStateOf(SplashScreenUiState())
        private set

    init {
        viewModelScope.launch {
            checkInitCookDataBase()
        }
    }

    private suspend fun checkInitCookDataBase() {
        splashScreenRepository.get().checkInitCookBookDataBase()
            .collect { result ->
                when (result) {
                    is RequestResult.Success -> {
                        if (result.data) {
                            state =
                                state.copy(navigateToNext = true, error = null)
                        } else {
                            initCookDataBase()
                        }
                    }

                    is RequestResult.Error -> {
                        state = state.copy(
                            error = result.error,
                            navigateToNext = false
                        )
                    }
                }
            }
    }

    private suspend fun initCookDataBase() {
        splashScreenRepository.get()
            .setAllNationalFoodsType()
            .collect { result ->
                when (result) {
                    is RequestResult.Success -> {
                        if (result.data) {
                            state =
                                state.copy(navigateToNext = true, error = null)
                        }
                    }

                    is RequestResult.Error -> {
                        state = state.copy(
                            error = result.error,
                            navigateToNext = false
                        )
                    }
                }
            }
    }
}
