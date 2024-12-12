package com.domesoft.gamebox

import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan

fun buildSpan(text: String, spanStart: Int, spanColor: String): SpannableStringBuilder? {
    val sb = SpannableStringBuilder(text)
    // Span to set text color to some RGB value
    val fcs = ForegroundColorSpan(Color.parseColor(spanColor))
    // Span to make text bold
    val bss = StyleSpan(Typeface.BOLD)
    // Set the text color for first 4 characters
    sb.setSpan(fcs, spanStart, text.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
    // make them also bold
    sb.setSpan(bss, spanStart, text.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)

    return sb
}