package com.noxis.cookbook.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.noxis.splash.presentation.components.SplashScreen

fun NavGraphBuilder.splashScreen() {
    composable<Root.SplashScreen> {
        SplashScreen()
    }
}
