package com.noxis.cookbook.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.noxis.splash.presentation.components.SplashScreen

fun NavGraphBuilder.splashScreen(navController: NavHostController) {
    composable<Root.SplashScreen> {
        SplashScreen(
            navigateToNext = {
                navController.popBackStack()
                navController.navigate(Root.NationalFoodsMenuScreen)
            }
        )
    }
}
