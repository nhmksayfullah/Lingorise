package com.lingorise.app.core.chunkeycourse

data class Chunk(
    val index: Int = 0,
    val chunkType: ChunkType,
    val chunk: Any
)