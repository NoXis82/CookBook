package com.noxis.cookbook.navigation

import kotlinx.serialization.Serializable

sealed interface Root {

    @Serializable
    data object NationalFoodsMenuScreen : Root

    @Serializable
    data object SplashScreen : Root
}
