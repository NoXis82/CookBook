package com.noxis.splash.presentation.components

import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.noxis.splash.R
import com.noxis.splash.presentation.state.SplashScreenUiState
import com.noxis.splash.presentation.viewmodel.SplashScreenViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToNext: () -> Unit
) {
    val viewModel: SplashScreenViewModel = hiltViewModel()

    SplashScreenContent(
        stateUi = viewModel.state,
        navigateToNext = { navigateToNext.invoke() }
    )

}

@Composable
internal fun SplashScreenContent(
    stateUi: SplashScreenUiState,
    navigateToNext: () -> Unit
) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnimated = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        alphaAnimated.animateTo(
            if (startAnimation) 0f else 1f,
            animationSpec = tween(2000)
        )
        startAnimation = true
    }

    LaunchedEffect(stateUi) {
        delay(1500)
        when {
            stateUi.navigateToNext -> navigateToNext.invoke()

            stateUi.error != null -> {
                Log.d("TAG", "SplashScreenContent: ${stateUi.error}")
            }
        }
    }

    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logos),
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha = alphaAnimated.value),
            contentDescription = null
        )

    }
}
