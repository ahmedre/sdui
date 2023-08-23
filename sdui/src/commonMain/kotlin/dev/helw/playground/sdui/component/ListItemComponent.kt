package dev.helw.playground.sdui.component

import androidx.compose.runtime.Composable
import dev.helw.playground.sdui.Component
import dev.helw.playground.sdui.component.list.ListItemContentDescription
import dev.helw.playground.sdui.component.list.ListItemContentTitle
import dev.helw.playground.sdui.component.list.ListItemLeading
import dev.helw.playground.sdui.component.list.ListItemTrailing
import dev.helw.playground.sdui.design.component.listitem.ListItem
import dev.helw.playground.sdui.design.core.BackgroundColor
import dev.helw.playground.sdui.model.BackgroundColorToken
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("listItem")
class ListItemComponent(
    private val title: ListItemContentTitle,
    private val description: ListItemContentDescription? = null,
    private val leading: ListItemLeading? = null,
    private val trailing: ListItemTrailing? = null,
    private val backgroundColorToken: BackgroundColorToken? = null,
    override val type: String
) : Component {

    @Composable
    override fun Content() {
        ListItem(
            title = title.asListItemScope(),
            description = description?.asListItemScope() ?: {},
            leading = leading?.asListItemScope() ?: {},
            trailing = trailing?.asListItemScope() ?: {},
            backgroundColor = backgroundColorToken?.colorValue() ?: BackgroundColor.Unspecified
        )
    }
}