/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.action.Action
import dev.helw.playground.sdui.action.handleActions
import dev.helw.playground.sdui.component.list.ListItemContentDescription
import dev.helw.playground.sdui.component.list.ListItemContentTitle
import dev.helw.playground.sdui.component.list.ListItemLeading
import dev.helw.playground.sdui.component.list.ListItemTrailing
import dev.helw.playground.sdui.design.component.listitem.ListItem
import dev.helw.playground.sdui.design.core.BackgroundColor
import dev.helw.playground.sdui.model.Component
import dev.helw.playground.sdui.serializer.model.BackgroundColorToken
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("listItem")
class ListItemComponent(
    private val title: ListItemContentTitle,
    private val description: ListItemContentDescription? = null,
    private val leading: ListItemLeading? = null,
    private val trailing: ListItemTrailing? = null,
    private val backgroundColor: BackgroundColorToken? = null,
    override val identifier: String,
    override val actions: List<Action> = emptyList()
) : Component {

    @Composable
    override fun Content(modifier: Modifier) {
        ListItem(
            title = title.asListItemScope(),
            description = description?.asListItemScope() ?: {},
            leading = leading?.asListItemScope() ?: {},
            trailing = trailing?.asListItemScope() ?: {},
            backgroundColor = backgroundColor?.colorValue() ?: BackgroundColor.Unspecified,
            modifier = modifier.handleActions(actions)
        )
    }
}
