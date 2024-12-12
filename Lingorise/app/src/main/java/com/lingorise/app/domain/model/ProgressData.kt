package com.lingorise.app.domain.model

import androidx.compose.ui.graphics.Color
import com.lingorise.app.ui.theme.LingoriseSkyBlue

data class ProgressData(
    val value: Float,
    val outOf: Float,
    val title: String,
    val color: Color = LingoriseSkyBlue
)
