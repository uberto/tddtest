package com.example.domain

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import java.time.LocalDate

class DayCalculatorTest {
    
    @Test
    fun `should return Foo when day number is divisible by 5`() {
        val date = LocalDate.of(2024, 1, 5) // 5th day of year
        expectThat(calculateDayResult(date))
            .isEqualTo("Foo")
    }
    
    @Test
    fun `should return Baz when day number is divisible by 7`() {
        val date = LocalDate.of(2024, 1, 7) // 7th day of year
        expectThat(calculateDayResult(date))
            .isEqualTo("Baz")
    }
    
    @Test
    fun `should return FooBaz when day number is divisible by both 5 and 7`() {
        val date = LocalDate.of(2024, 2, 4) // 35th day of year
        expectThat(calculateDayResult(date))
            .isEqualTo("FooBaz")
    }
    
    @Test
    fun `should return day number when not divisible by 5 or 7`() {
        val date = LocalDate.of(2024, 1, 8) // 8th day of year
        expectThat(calculateDayResult(date))
            .isEqualTo("8")
    }
    
    @Test
    fun `should handle first day of year`() {
        val date = LocalDate.of(2024, 1, 1) // 1st day of year
        expectThat(calculateDayResult(date))
            .isEqualTo("1")
    }
    
    @Test
    fun `should handle last day of year in leap year`() {
        val date = LocalDate.of(2024, 12, 31) // 366th day of year (2024 is leap year)
        expectThat(calculateDayResult(date))
            .isEqualTo("366")
    }

    @Test
    fun `should handle last day of year in non-leap year`() {
        val date = LocalDate.of(2023, 12, 31) // 365th day of year (divisible by 5)
        expectThat(calculateDayResult(date))
            .isEqualTo("Foo")
    }

    @Test
    fun `should handle same calendar date in different years`() {
        val leapYearDate = LocalDate.of(2024, 3, 1)     // 61st day in leap year
        val nonLeapYearDate = LocalDate.of(2023, 3, 1)  // 60th day in non-leap year (divisible by 5)
        
        expectThat(calculateDayResult(leapYearDate))
            .isEqualTo("61")
        expectThat(calculateDayResult(nonLeapYearDate))
            .isEqualTo("Foo")
    }

    @Test
    fun `should return Foo for multiple dates divisible by 5 in non-leap year`() {
        val dates = listOf(
            LocalDate.of(2023, 1, 5),   // 5th day
            LocalDate.of(2023, 1, 10),  // 10th day
            LocalDate.of(2023, 1, 15)   // 15th day
        )
        
        dates.forEach { date ->
            expectThat(calculateDayResult(date))
                .isEqualTo("Foo")
        }
    }

    @Test
    fun `should return Baz for multiple dates divisible by 7 in non-leap year`() {
        val dates = listOf(
            LocalDate.of(2023, 1, 7),   // 7th day
            LocalDate.of(2023, 1, 14),  // 14th day
            LocalDate.of(2023, 1, 21)   // 21st day
        )
        
        dates.forEach { date ->
            expectThat(calculateDayResult(date))
                .isEqualTo("Baz")
        }
    }
} 