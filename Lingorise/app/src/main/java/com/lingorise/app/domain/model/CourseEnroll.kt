package com.lingorise.app.domain.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class CourseEnroll(
    val userId: String? = null,
    val opponentId: String? = null,
    val userProgress: Double? = null,
    val opponentProgress: Double? = null,
    val isUserActive: Boolean? = null,
    val isOpponentActive: Boolean? = null
)
