package com.noxis.nationalfood.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.noxis.domain.utils.RequestResult
import com.noxis.nationalfood.domain.repository.NationalFoodsRepository
import com.noxis.nationalfood.presentation.event.NationalFoodsUiEvent
import com.noxis.nationalfood.presentation.state.NationalFoodsUiState
import com.noxis.presentation.viewmodel.StateAndEventViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class NationalFoodsViewModel @Inject internal constructor(
    private val nationalFoodsRepository: Provider<NationalFoodsRepository>
) : StateAndEventViewModel<NationalFoodsUiState, NationalFoodsUiEvent>(
    NationalFoodsUiState()
) {


    override suspend fun handleEvent(uiEvent: NationalFoodsUiEvent) {
        when (uiEvent) {
            NationalFoodsUiEvent.GetAllNationalFoodsType -> getAllTypeFoods()
        }
    }

    private fun getAllTypeFoods() {
        viewModelScope.launch {
            nationalFoodsRepository.get()
                .getAllNationalFoodsType()
                .collectLatest { result ->
                    when (result) {
                        is RequestResult.Success -> {
                            updateUIState {
                                copy(error = null, type = result.data)
                            }
                        }

                        is RequestResult.Error -> {
                            updateUIState {
                                copy(error = result.error)
                            }
                        }
                    }
                }
        }
    }
}
