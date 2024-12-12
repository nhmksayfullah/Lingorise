package com.lingorise.app.core.spotlight.blocks

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.lingorise.app.core.spotlight.provider.rememberExoPlayerWithLifecycle
import com.lingorise.app.core.spotlight.provider.rememberPlayerView
import com.lingorise.app.data.repository.fakedata.fakeSpotlight
import com.lingorise.app.domain.model.SpotlightData
import com.lingorise.app.ui.theme.LingoriseYellow
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SpotlightView(
    modifier: Modifier = Modifier,
    spotlightData: SpotlightData,
    isPaused: Boolean,
    onPaused: (Boolean) -> Unit,
    shouldPlay: Boolean,
    isScrolling: Boolean
) {
    val exoPlayer = rememberExoPlayerWithLifecycle(spotlightData.url)
    val playerView = rememberPlayerView(exoPlayer = exoPlayer)
    var playPauseIconVisibility by remember {
        mutableStateOf(false)
    }
    var playing by remember {
        mutableStateOf(true)
    }

    val scope = rememberCoroutineScope()

    Box {
        AndroidView(
            factory = { playerView },
            modifier = modifier
                .pointerInput(isPaused) {
                    detectTapGestures (
                        onTap = {
                            if(playing) {
                                exoPlayer.pause()
                                playing = false
                                onPaused(true)
                            } else {
                                exoPlayer.play()
                                playing = true
                                onPaused(false)
                            }
//                            if(exoPlayer.playWhenReady) {
//                                if(isPaused.not()) {
//                                    exoPlayer.playWhenReady = false
//                                    onPaused(true)
//                                } else {
//                                    exoPlayer.playWhenReady = true
//                                    onPaused(false)
//                                }
//                                scope.launch {
//                                    playPauseIconVisibility = true
//                                    delay(800)
//                                    playPauseIconVisibility = false
//                                }
//                            }


                        },
                        onPress = {
                            if(!isScrolling) {
                                exoPlayer.playWhenReady = false
                                awaitRelease()
                                exoPlayer.playWhenReady = true
                            }
                        }
                    )
                },
            update = {
                exoPlayer.playWhenReady = shouldPlay

            }
        )

        AnimatedVisibility(
            visible = playPauseIconVisibility,
            enter = scaleIn(
                spring(Spring.DampingRatioMediumBouncy)
            ),
            exit = scaleOut(tween(150)),
            modifier = Modifier.align(Alignment.Center)
        ) {
            if(playPauseIconVisibility) {
                Icon(
                    imageVector = if(isPaused) Icons.Filled.PlayArrow else Icons.Filled.PlayArrow,
                    contentDescription = "play pause button",
                    tint = LingoriseYellow,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(100.dp)
                )
            }
        }
    }

    DisposableEffect(key1 = true) {
        onDispose {
            exoPlayer.release()
        }
    }

}

@Preview
@Composable
fun SpotlightPreview() {
    SpotlightView(
        spotlightData = fakeSpotlight[0],
        isPaused = false,
        onPaused = {},
        shouldPlay = true,
        isScrolling = false

    )
}
