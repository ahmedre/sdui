/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.helw.playground.sdui.action.ActionHandler
import dev.helw.playground.sdui.action.LocalServerDrivenUiActionHandler
import dev.helw.playground.sdui.action.OnClick
import dev.helw.playground.sdui.action.OnViewed
import dev.helw.playground.sdui.design.core.color.LocalBackgroundColors

/**
 * Used only by Desktop and Web
 */
@Composable
internal fun FullScreenDemo(modifier: Modifier = Modifier) {
    val actionHandler = object : ActionHandler {
        var text: String = ""

        override suspend fun onClick(action: OnClick) {
            text = when (action) {
                is OnClick.Deeplink -> {
                    "Deeplink to ${action.deeplink}"
                }

                is OnClick.InteractionEvent -> {
                    "Interaction Event\nname: ${action.eventName}, data: ${action.data}"
                }
            }
            println("--------> ONCLICK: $text")
        }

        override suspend fun onViewed(action: OnViewed) {
            text = when (action) {
                is OnViewed.ImpressionEvent -> {
                    "Impression Event\nname: ${action.eventName}, data: ${action.data}"
                }
            }
            println("--------> ONVIEWED: $text")
        }
    }
    CompositionLocalProvider(LocalServerDrivenUiActionHandler provides actionHandler) {
        Surface(modifier = modifier.fillMaxSize()) {
            var destination by remember { mutableStateOf(NavigationGraph[0]) }
            Column(modifier = Modifier.fillMaxSize()) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    MainDemo(
                        graph = NavigationGraph,
                        modifier = Modifier.weight(2f),
                        onClick = { destination = it })
                    Spacer(
                        modifier = Modifier
                            .width(1.dp)
                            .fillMaxHeight()
                            .background(color = LocalBackgroundColors.current.primary.color)
                    )
                    destination.content.invoke(
                        Modifier
                            .weight(3f)
                            .padding(horizontal = 16.dp)
                            .padding(top = 16.dp)
                    )
                }
            }
        }
    }
}
