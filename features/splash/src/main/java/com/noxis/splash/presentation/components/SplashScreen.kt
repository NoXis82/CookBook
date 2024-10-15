package com.noxis.splash.presentation.components

import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.noxis.splash.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToNext: () -> Unit
) {
    SplashScreenContent { navigateToNext.invoke() }
}

@Composable
internal fun SplashScreenContent(
    navigateToNext: () -> Unit
) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnimated by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(1500),
        label = "alpha"
    )

    LaunchedEffect(true) {
        startAnimation = true
        delay(1800)
        navigateToNext.invoke()
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
                .graphicsLayer {
                    alpha = alphaAnimated
                },
            contentDescription = null
        )
    }
}
