package com.lingorise.app.domain.model

data class FeedPostData(
    val title: String,
    val content: String,
    val image: Int? = null,
    val isLiked: Boolean = false
)
