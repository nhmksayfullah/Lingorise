//@file:UnstableApi

package com.lingorise.app.core.spotlight


//import android.content.Context
//import android.os.Environment
//import android.view.ViewGroup
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.platform.LocalLifecycleOwner
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.viewinterop.AndroidView
//import androidx.lifecycle.Lifecycle
//import androidx.lifecycle.LifecycleEventObserver
//import androidx.media3.common.C
//import androidx.media3.common.MediaItem
//import androidx.media3.common.Player
//import androidx.media3.common.util.UnstableApi
//import androidx.media3.exoplayer.DefaultRenderersFactory
//import androidx.media3.exoplayer.ExoPlayer
//import androidx.media3.exoplayer.RenderersFactory
//import androidx.media3.exoplayer.trackselection.DefaultTrackSelector
//import androidx.media3.ui.AspectRatioFrameLayout.RESIZE_MODE_FIT
//import androidx.media3.ui.PlayerView
//import androidx.media3.ui.PlayerView.SHOW_BUFFERING_ALWAYS

//
//@Preview
//@Composable
//fun CoreSpotlight() {
//    val uri = "${Environment.getExternalStorageDirectory().absolutePath}/LingoriseContent/cs1_vid1.mp4"
//    SpotlightView(uri = uri)
//}
//
//@Composable
//fun getExoPlayerInstance(): ExoPlayer {
//    val context = LocalContext.current
//    val renderersFactory = remember {
//        buildRenderersFactory(context, true)
//    }
//    val trackSelector = remember {
//        DefaultTrackSelector(context.applicationContext)
//    }
//
//    val exoPlayer = remember {
//        ExoPlayer.Builder(context, renderersFactory)
//            .setTrackSelector(trackSelector)
//            .build().apply {
//                trackSelectionParameters = DefaultTrackSelector.Parameters.Builder(context).build()
//                videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT
//                repeatMode = Player.REPEAT_MODE_ONE
//                setHandleAudioBecomingNoisy(true)
//                playWhenReady = false
//            }
//    }
//
//    var backgroundPlay by remember {
//        mutableStateOf(false)
//    }
//
//    val lifecycleOwner = LocalLifecycleOwner.current
//    DisposableEffect(key1 = lifecycleOwner, backgroundPlay) {
//        val lifecycleObserver = getExoPlayerLifecycleObserver(exoPlayer, backgroundPlay) {
//            backgroundPlay = it
//        }
//        lifecycleOwner.lifecycle.addObserver(lifecycleObserver)
//        onDispose {
//            lifecycleOwner.lifecycle.removeObserver(lifecycleObserver)
//        }
//    }
//
//    return exoPlayer
//}
//
//@Composable
//fun getPlayerViewInstance(exoPlayer: ExoPlayer): PlayerView {
//    val context = LocalContext.current
//    val playerView = remember {
//        PlayerView(context).apply {
//            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
//            resizeMode = RESIZE_MODE_FIT
//            setShowBuffering(SHOW_BUFFERING_ALWAYS)
//            useController = false
//            player = exoPlayer
//        }
//    }
//
//    DisposableEffect(key1 = true) {
//        onDispose {
//            playerView.player = null
//        }
//    }
//    return playerView
//}
//
//
//@Composable
//fun SpotlightView(uri: String) {
//    val mediaItem = remember {
//        mutableStateOf(MediaItem.fromUri(uri))
//    }
//    val playing = remember {
//        mutableStateOf(true)
//    }
//    val exoPlayer = getExoPlayerInstance()
//    val playerView = getPlayerViewInstance(exoPlayer = exoPlayer)
//    exoPlayer.setMediaItem(mediaItem.value)
//    Box(modifier = Modifier.fillMaxSize()) {
//        AndroidView(factory = { playerView },
//            modifier = Modifier
//                .clickable {
//                    if(playing.value) exoPlayer.pause() else exoPlayer.play()
//                    playing.value = !playing.value
//                },
//            update = {
//                exoPlayer.volume = 1f
//                exoPlayer.prepare()
//                exoPlayer.playWhenReady = true
//            })
//    }
//
//    DisposableEffect(key1 = true) {
//        onDispose {
//            exoPlayer.release()
//        }
//    }
//
//}
//
//fun buildRenderersFactory(context: Context, preferExtensionRenderer: Boolean): RenderersFactory {
//    val extensionRendererMode = if(preferExtensionRenderer) {
//        DefaultRenderersFactory.EXTENSION_RENDERER_MODE_PREFER
//    } else {
//        DefaultRenderersFactory.EXTENSION_RENDERER_MODE_ON
//    }
//
//    return DefaultRenderersFactory(context.applicationContext)
//        .setExtensionRendererMode(extensionRendererMode)
//        .setEnableDecoderFallback(true)
//}
//
//
//fun getExoPlayerLifecycleObserver(exoPlayer: ExoPlayer, wasInBackground: Boolean, setInBackground: (Boolean) -> Unit): LifecycleEventObserver =
//    LifecycleEventObserver{ _, event ->
//        when(event) {
//            Lifecycle.Event.ON_RESUME -> {
//                if (wasInBackground)
//                    exoPlayer.playWhenReady = true
//                setInBackground(false)
//            }
//            Lifecycle.Event.ON_PAUSE -> {
//                exoPlayer.playWhenReady = false
//                setInBackground(true)
//            }
//            Lifecycle.Event.ON_STOP -> {
//                exoPlayer.playWhenReady = false
//                setInBackground(true)
//            }
//            Lifecycle.Event.ON_DESTROY -> {
//                exoPlayer.release()
//            }
//            else -> {}
//        }
//    }



/* ----------------These bulk came from Spotlight file---------------- */


//private const val TAG = "Player"

//private fun playbackStateListener() = object : Player.Listener {
//    override fun onPlaybackStateChanged(playbackState: Int) {
//        val stateString = when(playbackState) {
//            ExoPlayer.STATE_IDLE -> "Exoplayer.STATE_IDLE -"
//            ExoPlayer.STATE_BUFFERING -> "ExoPlayer.STATE_BUFFERING -"
//            ExoPlayer.STATE_READY -> "ExoPlayer.STATE_READY -"
//            ExoPlayer.STATE_ENDED -> "ExoPlayer.STATE_ENDED -"
//            else -> "UNKNOWN_STATE"
//        }
//        Log.d(TAG, "changed state to $stateString")
//    }
//}


//private fun initializePlayer(context: Context): ExoPlayer {
//
//    val trackSelector = DefaultTrackSelector(context).apply {
//        setParameters(buildUponParameters().setMaxVideoSizeSd())
//    }
//
//    return ExoPlayer.Builder(context)
//        .setTrackSelector(trackSelector)
//        .build()
//}

//@Composable
//fun SpotlightPlayerView() {
//    val exoPlayer = initializePlayer(LocalContext.current)
//    exoPlayer.prepare()
//    val mediaItem = MediaItem.fromUri("https://www.lingorise.com/fakecontent/watch/watch1.mp4")
//    exoPlayer.setMediaItem(mediaItem)
//
//    val playbackStateListener = playbackStateListener()
//    exoPlayer.addListener(playbackStateListener)
//    exoPlayer.playWhenReady
//
//
//    var lifecycle by remember {
//        mutableStateOf(Lifecycle.Event.ON_CREATE)
//    }
//    val lifecycleOwner = LocalLifecycleOwner.current
//    DisposableEffect(lifecycleOwner) {
//        val observer = LifecycleEventObserver { _, event ->
//            lifecycle = event
//        }
//        lifecycleOwner.lifecycle.addObserver(observer)
//        onDispose {
//            lifecycleOwner.lifecycle.removeObserver(observer)
//        }
//    }
//
//
//    AndroidView(
//        factory = { context ->
//            PlayerView(context).also {
//                it.player = exoPlayer
//            }.also {
//                exoPlayer.playWhenReady
//                it.player?.play()
//            }
//        },
//        update = {
//
//            when (lifecycle) {
//                Lifecycle.Event.ON_PAUSE -> {
//                    it.onPause()
//                    it.player?.pause()
//                }
//                Lifecycle.Event.ON_RESUME -> {
//                    it.onResume()
//                }
//                else -> Unit
//            }
//
//        },
//        modifier = Modifier
//            .fillMaxSize()
//            .aspectRatio(9 / 16f)
//    )
//
//}

