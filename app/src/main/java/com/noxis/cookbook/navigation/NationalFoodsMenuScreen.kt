package com.noxis.cookbook.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.noxis.cookbook.NationalFoodsMenuScreen
import com.noxis.nationalfood.presentation.components.NationalFoodsMenuScreen

fun NavGraphBuilder.nationalFoodsMenuScreen() {
    composable<NationalFoodsMenuScreen> {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            NationalFoodsMenuScreen(
                modifier = Modifier.padding(
                    innerPadding
                )
            )
        }
    }
}
