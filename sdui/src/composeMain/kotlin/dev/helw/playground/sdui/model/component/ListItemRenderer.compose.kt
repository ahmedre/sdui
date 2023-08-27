package dev.helw.playground.sdui.model.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.component.list.ListItemContentDescription
import dev.helw.playground.sdui.component.list.ListItemContentTitle
import dev.helw.playground.sdui.component.list.ListItemLeading
import dev.helw.playground.sdui.component.list.ListItemTrailing
import dev.helw.playground.sdui.design.component.listitem.ListItem
import dev.helw.playground.sdui.design.core.BackgroundColor
import dev.helw.playground.sdui.model.Renderer
import dev.helw.playground.sdui.serializer.model.BackgroundColorToken

class ListItemRenderer(
    private val title: ListItemContentTitle,
    private val description: ListItemContentDescription? = null,
    private val leading: ListItemLeading? = null,
    private val trailing: ListItemTrailing? = null,
    private val backgroundColor: BackgroundColorToken? = null
) : Renderer {

    @Composable
    override fun Content(modifier: Modifier) {
        ListItem(
            title = title.renderer().render(),
            description = description?.renderer()?.render() ?: {},
            leading = leading?.renderer()?.render() ?: {},
            trailing = trailing?.renderer()?.render() ?: {},
            backgroundColor = backgroundColor?.colorValue() ?: BackgroundColor.Unspecified
        )
    }
}