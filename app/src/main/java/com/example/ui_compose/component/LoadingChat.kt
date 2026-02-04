package com.example.ui_compose.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.ui_compose.R


@Composable
fun LoadingChat(
    modifier: Modifier = Modifier
){
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.wave_loading)
    )
    val process by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = true,
        iterations = LottieConstants.IterateForever
    )

    LottieAnimation(
        composition = composition,
        progress = process,
        modifier = modifier
    )

}