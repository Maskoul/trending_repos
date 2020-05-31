package com.example.trendingrepos.Util

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import kotlin.math.ln
import kotlin.math.pow


fun main() {

}

fun getTimeQuery(inLast: Int): String {
    val dateTime: DateTime = DateTime.now().minusDays(inLast)
    val dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd")

    return "created:>${dateTime.toString(dateTimeFormatter)}"

}

fun getFormattedNumber(count: Long): String {
    if (count < 1000) return count.toString()
    val exp = (ln(count.toDouble()) / ln(1000.0)).toInt()
    return String.format("%.1f %c", count / 1000.0.pow(exp.toDouble()), "kMGTPE"[exp - 1])
}