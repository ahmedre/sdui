package dev.helw.playground.sdui.network

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.js.JsClient

actual fun sduiClient(config: HttpClientConfig<*>.() -> Unit): HttpClient = HttpClient(JsClient()) {
    config(this)
}