package com.example.trendingrepos.Util

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat


fun getTimeQuery(inLast : Int) : String{
    val dateTime: DateTime = DateTime.now().minusDays(inLast)
    val dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd")

    return "created:>${dateTime.toString(dateTimeFormatter)}"

}