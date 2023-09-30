/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.network

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig

expect fun sduiClient(config: HttpClientConfig<*>.() -> Unit = {}): HttpClient
