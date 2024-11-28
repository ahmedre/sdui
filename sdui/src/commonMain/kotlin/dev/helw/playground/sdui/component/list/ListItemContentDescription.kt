/**
 * Copyright (c) 2024 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.component.list

import androidx.compose.runtime.Composable
import dev.helw.playground.sdui.design.component.listitem.ListItemScope
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class ListItemContentDescription {
    abstract fun asListItemScope(): @Composable ListItemScope.Content.Description.() -> Unit

    @Serializable
    @SerialName("description")
    data class DescriptionContentTitle(val text: String) : ListItemContentDescription() {
        override fun asListItemScope(): @Composable ListItemScope.Content.Description.() -> Unit =
            { Description(text) }
    }
}
