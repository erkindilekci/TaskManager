package com.erkindilekci.taskmanager.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object Utils {

    private val dateFullFormatter = SimpleDateFormat("dd/MM/yyyy hh:mm", Locale.ROOT)

    fun convertStringToCalendar(date: String, time: String): Calendar {
        val calendar = Calendar.getInstance()
        val calendarNewDate = dateFullFormatter.parse("$date $time")
        calendar.time = calendarNewDate
        return calendar
    }
}
