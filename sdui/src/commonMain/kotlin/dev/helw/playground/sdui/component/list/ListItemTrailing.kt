/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.component.list

import androidx.compose.runtime.Composable
import dev.helw.playground.sdui.design.component.listitem.ListItemScope
import dev.helw.playground.sdui.design.core.IconToken
import dev.helw.playground.sdui.design.core.SizeToken
import dev.helw.playground.sdui.serializer.IconTokenSerializer
import dev.helw.playground.sdui.serializer.SizeTokenSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class ListItemTrailing {
    abstract fun asListItemScope(): @Composable ListItemScope.Trailing.() -> Unit

    @SerialName("detail")
    @Serializable
    data class DetailTrailing(
        val text: String
    ) : ListItemTrailing() {
        override fun asListItemScope(): @Composable ListItemScope.Trailing.() -> Unit =
            { Detail(text) }
    }

    @SerialName("statusIcon")
    @Serializable
    data class StatusIconTrailing(
        @Serializable(with = IconTokenSerializer::class)
        private val icon: IconToken,
        @Serializable(with = SizeTokenSerializer::class)
        private val size: SizeToken,
    ) : ListItemTrailing() {
        override fun asListItemScope(): @Composable ListItemScope.Trailing.() -> Unit =
            { StatusIcon(icon, size) }
    }
}
