/**
 * Copyright (c) 2024 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.action.Action
import dev.helw.playground.sdui.action.handleActions
import dev.helw.playground.sdui.design.component.Label
import dev.helw.playground.sdui.design.core.TypographyToken
import dev.helw.playground.sdui.model.Component
import dev.helw.playground.sdui.serializer.TypographyTokenSerializer
import dev.helw.playground.sdui.serializer.model.TextColorToken
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("label")
class LabelComponent(
    private val text: String,
    @Serializable(with = TypographyTokenSerializer::class)
    private val typography: TypographyToken,
    private val color: TextColorToken,
    override val identifier: String,
    override val actions: List<Action> = emptyList()
) : Component {

    @Composable
    override fun Content(modifier: Modifier) {
        Label(
            text = text,
            typographyToken = typography,
            textColor = color.colorValue(),
            modifier = modifier.handleActions(actions)
        )
    }
}
