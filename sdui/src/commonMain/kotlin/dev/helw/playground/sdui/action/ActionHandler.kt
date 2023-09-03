package dev.helw.playground.sdui.action

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf

interface ActionHandler {
    suspend fun onClick(action: OnClick) {}
    suspend fun onViewed(action: OnViewed) {}
}

val LocalServerDrivenUiActionHandler = staticCompositionLocalOf<ActionHandler> { error("nothing provided") }