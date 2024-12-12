package com.lingorise.app.navigation.screens

sealed class CourseScreen(val route: String) {
    object EnrollCourseScreen: CourseScreen(route = "enroll_course_screen")
    object EnrolledCourseScreen: CourseScreen("enrolled_course_screen")
    object RunningCourseScreen: CourseScreen("running_course_screen")
    object CourseCompletedScreen: CourseScreen("course_completed_screen")
    object SelectFriendScreen: CourseScreen("select_friend_screen")
}
