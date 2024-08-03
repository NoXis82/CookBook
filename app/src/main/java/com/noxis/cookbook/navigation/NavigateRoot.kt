package com.noxis.cookbook.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigateRoot() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Root.SplashScreen
    ) {
        splashScreen(navController)
        nationalFoodsMenuScreen()
    }
}
