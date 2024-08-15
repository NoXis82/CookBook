package com.noxis.splash.presentation.state

import androidx.compose.runtime.Immutable
import com.noxis.domain.utils.RepositoryError

@Immutable
data class SplashScreenUiState(
    val error: RepositoryError? = null,
    val navigateToNext: Boolean = false
)
