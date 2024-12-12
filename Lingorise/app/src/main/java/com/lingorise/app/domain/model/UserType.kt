package com.lingorise.app.domain.model

enum class UserType(val key: String) {
    FIRST_TIME("first"),
    COURSE_ENROLLED("enrolled")
}

class UserKey {
    val FIRST_TIME = "first"
    val SECOND_TIME = "second"
    val COURSE_ENROLLED = "enrolled"
}