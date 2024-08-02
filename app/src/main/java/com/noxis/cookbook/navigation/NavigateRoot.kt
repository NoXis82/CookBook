package com.noxis.cookbook.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.noxis.cookbook.NationalFoodsMenuScreen

@Composable
fun NavigateRoot() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NationalFoodsMenuScreen
    ) {
        nationalFoodsMenuScreen()
    }
}
