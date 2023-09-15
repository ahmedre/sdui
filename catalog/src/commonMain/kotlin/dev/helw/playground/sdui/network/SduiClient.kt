package dev.helw.playground.sdui.network

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig

expect fun sduiClient(config: HttpClientConfig<*>.() -> Unit = {}): HttpClient