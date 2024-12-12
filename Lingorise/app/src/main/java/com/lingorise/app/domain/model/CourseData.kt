package com.lingorise.app.domain.model

import com.google.firebase.database.IgnoreExtraProperties
import com.lingorise.app.core.chunkeycourse.Chunk

@IgnoreExtraProperties
data class CourseData(
    val id: Int? = null,
    val thumbnail: Int? = null,
    val title: String? = null,
    val shortDescription: String? = null,
    val longDescription: String? = null,
    val progressData: ProgressData? = null,
    val chunks: List<Chunk>? = null
)
