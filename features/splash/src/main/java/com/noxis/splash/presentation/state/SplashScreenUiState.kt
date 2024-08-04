package com.noxis.splash.presentation.state

import com.noxis.domain.utils.RepositoryError

data class SplashScreenUiState(
    val error: RepositoryError? = null
)
