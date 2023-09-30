/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.component.core

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.action.Action
import dev.helw.playground.sdui.model.Component
import dev.helw.playground.sdui.model.SduiModifier
import dev.helw.playground.sdui.model.applyModifiers
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("row")
class RowComponent(
    private val contents: List<Component>,
    private val modifiers: List<SduiModifier> = emptyList(),
    override val identifier: String,
    override val actions: List<Action> = emptyList()
) : Component {

    @Composable
    override fun Content(modifier: Modifier) {
        Row(modifier.applyModifiers(modifiers)) {
            contents.forEach { it.Content(Modifier) }
        }
    }
}
