package com.domesoft.gamebox.fillthegap

fun replaceString(string1: String, string2: String): StringBuilder{
    val length: Int = string1.length
    val dot = java.lang.StringBuilder()
    for (i in 0..length) {
        dot.append(string2)
    }
    return dot
}