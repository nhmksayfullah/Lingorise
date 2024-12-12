package com.lingorise.app.core.gamebox.quizer.model

data class Quiz(
    val question: String,
    val options: List<Option>,
    val answer: Option
)

data class Option(
    val index: Int,
    val label: String,
    val correctMassage: String? = "Wow Great!",
    val wrongMassage: String?
)
