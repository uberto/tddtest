package com.example.domain

import java.time.LocalDate

fun calculateDayResult(date: LocalDate): String =
    date.dayOfYear.let { dayNumber ->
        when {
            dayNumber % 5 == 0 && dayNumber % 7 == 0 -> "FooBaz"
            dayNumber % 5 == 0 -> "Foo"
            dayNumber % 7 == 0 -> "Baz"
            else -> dayNumber.toString()
        }
    }
