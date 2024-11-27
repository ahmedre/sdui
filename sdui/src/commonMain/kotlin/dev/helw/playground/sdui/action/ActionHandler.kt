/**
 * Copyright (c) 2024 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.action

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf

interface ActionHandler {
    suspend fun onClick(action: OnClick) {}
    suspend fun onViewed(action: OnViewed) {}
}

val LocalServerDrivenUiActionHandler = staticCompositionLocalOf<ActionHandler> { error("nothing provided") }
