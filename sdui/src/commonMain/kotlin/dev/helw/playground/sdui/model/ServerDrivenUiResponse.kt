package dev.helw.playground.sdui.model

import kotlinx.serialization.Serializable

@Serializable
class ServerDrivenUiResponse(
    val root: Component,
    val version: Int
)