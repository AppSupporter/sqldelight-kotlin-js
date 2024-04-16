package de.codecreators.youtrackkotlinjs

import kotlinx.datetime.Clock
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

//const val message = "Hello There!"

@OptIn(ExperimentalJsExport::class)
@JsExport
class Greeting() {
    private val platform: String = getPlatform()

    fun greet() {
        println("Hello, ${platform}! - ${getTimestamp()}")
    }

    private fun getTimestamp(): Long {
        return Clock.System.now().epochSeconds
    }
}