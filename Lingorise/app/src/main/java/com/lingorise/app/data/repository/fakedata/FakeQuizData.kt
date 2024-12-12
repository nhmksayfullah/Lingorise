package com.lingorise.app.data.repository.fakedata

import com.lingorise.app.core.gamebox.quizer.model.Option
import com.lingorise.app.core.gamebox.quizer.model.Quiz

val quiz1 = Quiz(
    question = "Which is the word that is similar to sophisticated?",
    options = listOf(
        Option(
            index = 1,
            label = "Good",
            wrongMassage = "Good মানে ভালো। কিন্তু শব্দটি Sophisticated শব্দের সমার্থক নয়।"),
        Option(
            index = 2,
            label = "Bright",
            wrongMassage = "Bright মানে উজ্জল। কিন্তু শব্দটি Sophisticated শব্দের সমার্থক নয়।"),
        Option(
            index = 3,
            label = "Valuable",
            wrongMassage = "Valuable মানে মূল্যবান। কিন্তু শব্দটি Sophisticated শব্দের সমার্থক নয়।"),
        Option(
            index = 4,
            label ="Advanced",
            wrongMassage = "",
            correctMassage = "Advanced মানে উন্নত। তাই শব্দটিকে Sophisticated শব্দের সমার্থক বলা যায়।")
    ),
    answer = Option(
        index =4,
        label ="Advanced",
        wrongMassage = "",
        correctMassage = "Advanced মানে উন্নত। তাই শব্দটিকে Sophisticated শব্দের সমার্থক বলা যায়।")
)
val quiz2 = Quiz(
    question = "Which is the correct use of sophisticated?",
    options = listOf(
        Option(
            index = 1,
            label = "British voters have become much more sophisticated",
        wrongMassage = ""),
        Option(
            index = 2,
            label = "You get sophisticated with time",
        wrongMassage = "সময়ের সাথে সাথে মানুষ বা জীব অত্যাধুনিক হয় না। বরং কোনো বস্তু অত্যাধুনিক হয়। যেহুতু এখানে You  দিয়ে একজন বেক্তিকে বুঝানো হয়েছে তাই এই উত্তরটি ভুল।"),
        Option(
            index = 3,
            label = "Sophisticated is good for health",
        wrongMassage = "Sophisticated শব্দটি একটি Adjective, কিন্তু এই বাক্যে এটি Noun হিসেবে ব্যবহৃত হয়েছে। তাই উত্তরটি সঠিক নয়।"),
        Option(
            index = 4,
            label = "Her eyes were sophisticated with tears.",
        wrongMassage = "Sophisticated অর্থ হচ্ছে অত্যাধুনিক। মানুষ কান্না করলে অত্যাধুনিক হয় না তাই উত্তরটি সঠিক নয়।"),
    ),
    answer = Option(
        index = 1,
        label = "British voters have become much more sophisticated",
    wrongMassage = "")
)

//val quiz3 = Quiz(
//    question = "What is the meaning of 3?",
//    options = listOf(
//        Option(1, "One"),
//        Option(2, "Two"),
//        Option(3, "Three"),
//        Option(4, "Four"),
//    ),
//    answer = Option(3, "Three")
//)

fun fakeQuizData(): List<Quiz> = listOf(quiz1, quiz2)