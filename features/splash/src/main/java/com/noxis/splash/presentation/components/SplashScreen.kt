package com.noxis.splash.presentation.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import com.noxis.splash.presentation.event.SplashScreenUiEvent
import com.noxis.splash.presentation.viewmodel.SplashScreenViewModel

@Composable
fun SplashScreen() {
    val viewModel: SplashScreenViewModel = hiltViewModel()
    val stateUi by viewModel.uiState.collectAsState()

    LaunchedEffect(true) {
        viewModel.onUIEvent(SplashScreenUiEvent.CheckInitDataBase)
    }

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

    when {
        stateUi.error != null -> {}

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
