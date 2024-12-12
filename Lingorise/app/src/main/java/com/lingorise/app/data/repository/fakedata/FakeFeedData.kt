package com.lingorise.app.data.repository.fakedata

import com.lingorise.app.R
import com.lingorise.app.domain.model.FeedPostData

fun fakeFeedData(): List<FeedPostData> {

    val post1 = FeedPostData(
        "How to learn English quickly: 10 tips",
        "Classic literature, paperbacks, newspapers, websites, emails, your social media feed, cereal boxes: if it’s in English, read it. Why? Well, this content will be full of juicy new vocabulary, as well as a fair amount you already know. This helps you improve quickly, as re-exposure to learned vocabulary gives you new examples in context, therefore reinforcing those words in your mind. On the other hand, learning new words and expressions is essential to building your vocabulary arsenal, particularly in a language like English with so many words! However, don’t just read and move on – next, you’ve got to…",
        R.drawable.lingorise_logo,
        true
    )

    val post2 = FeedPostData(
        "How to learn English step-by-step OR your quickest way to fluency",
        "Classic literature, paperbacks, newspapers, websites, emails, your social media feed, cereal boxes: if it’s in English, read it. Why? Well, this content will be full of juicy new vocabulary, as well as a fair amount you already know. This helps you improve quickly, as re-exposure to learned vocabulary gives you new examples in context, therefore reinforcing those words in your mind. On the other hand, learning new words and expressions is essential to building your vocabulary arsenal, particularly in a language like English with so many words! However, don’t just read and move on – next, you’ve got to…",
        R.drawable.lingorise_logo,
        false
    )

    val post3 = FeedPostData(
        "Read everything you can get your hands on",
        "Classic literature, paperbacks, newspapers, websites, emails, your social media feed, cereal boxes: if it’s in English, read it. Why? Well, this content will be full of juicy new vocabulary, as well as a fair amount you already know. This helps you improve quickly, as re-exposure to learned vocabulary gives you new examples in context, therefore reinforcing those words in your mind. On the other hand, learning new words and expressions is essential to building your vocabulary arsenal, particularly in a language like English with so many words! However, don’t just read and move on – next, you’ve got to…",
        null,
        false
    )

    val post4 = FeedPostData(
        "12 effective tips to learn English fast and easy",
        "Classic literature, paperbacks, newspapers, websites, emails, your social media feed, cereal boxes: if it’s in English, read it. Why? Well, this content will be full of juicy new vocabulary, as well as a fair amount you already know. This helps you improve quickly, as re-exposure to learned vocabulary gives you new examples in context, therefore reinforcing those words in your mind. On the other hand, learning new words and expressions is essential to building your vocabulary arsenal, particularly in a language like English with so many words! However, don’t just read and move on – next, you’ve got to…",
        R.drawable.lingorise_logo,
        true
    )


    return listOf(post1, post2, post3, post4)
}