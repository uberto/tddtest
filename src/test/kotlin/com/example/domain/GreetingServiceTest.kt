package com.example.domain

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class GreetingServiceTest {
    
    private val greetingService = GreetingService()
    
    @Test
    fun `should return greeting with name`() {
        expectThat(greetingService.greet("World"))
            .isEqualTo("Hello, World!")
    }
} 