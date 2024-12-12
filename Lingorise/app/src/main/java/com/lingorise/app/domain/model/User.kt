package com.lingorise.app.domain.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User(
    val userId: String? = null,
    val userName: String? = null,
    val email: String? = null,
    val lastName: String? = null
)
