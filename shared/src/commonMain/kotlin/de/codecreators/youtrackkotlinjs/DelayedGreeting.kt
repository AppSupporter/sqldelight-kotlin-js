package de.codecreators.youtrackkotlinjs

import kotlinx.coroutines.delay
import kotlinx.datetime.Clock

class DelayedGreeting() {
    private val platform: String = getPlatform()

    suspend fun greet() {
        delay(1000)
        println("Hello, ${platform}! - ${getTimestamp()}")
    }

    private fun getTimestamp(): Long {
        return Clock.System.now().epochSeconds
    }
}