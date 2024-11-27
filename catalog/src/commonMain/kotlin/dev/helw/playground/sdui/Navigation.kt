/**
 * Copyright (c) 2024 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.design.core.IconToken

internal val NavigationGraph = listOf(
    Destination(
        title = "Typography",
        subtitle = "Examples of currently supported typographies",
        icon = IconToken.INFO,
        content = { TypographyScene(it) }
    ),
    Destination(
        title = "Icons",
        subtitle = "Examples of currently supported Icons",
        icon = IconToken.PLACE,
        content = { IconScene(it) }
    ),
    Destination(
        title = "Sizes",
        subtitle = "Examples of currently supported Sizes",
        icon = IconToken.ADD,
        content = { SizeScene(it) }
    ),
    Destination(
        title = "Colors",
        subtitle = "Colors schemes currently supported",
        icon = IconToken.FAVORITE,
        content = { ColorScene(it) }
    ),
    Destination(
        title = "Progress Status",
        subtitle = "A progress indicator",
        icon = IconToken.CHECK,
        content = { ProgressStatusScene(it) }
    ),
    Destination(
        title = "Native List",
        subtitle = "A list built natively",
        icon = IconToken.LIST,
        content = { NativeListScene(it) }
    ),
    Destination(
        title = "Server Driven UI",
        subtitle = "UI rendered via json response",
        icon = IconToken.SETTINGS,
        content = { ServerDrivenUiScene(it) }
    ),
    Destination(
        title = "Server Driven UI: Sandbox",
        subtitle = "UI rendered via json response with sandbox",
        icon = IconToken.DELETE,
        content = { SandboxScene(it) }
    ),
)

data class Destination(
    val title: String,
    val subtitle: String,
    val icon: IconToken,
    val content: @Composable (Modifier) -> Unit = {},
) {
    val route: String by lazy {
        title.lowercase()
            .replace(Regex("\\W+"), "")
            .replace(Regex("\\s+"), "_")
    }
}
