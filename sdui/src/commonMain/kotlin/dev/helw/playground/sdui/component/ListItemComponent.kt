package dev.helw.playground.sdui.component

import dev.helw.playground.sdui.component.list.ListItemContentDescription
import dev.helw.playground.sdui.component.list.ListItemContentTitle
import dev.helw.playground.sdui.component.list.ListItemLeading
import dev.helw.playground.sdui.component.list.ListItemTrailing
import dev.helw.playground.sdui.model.Component
import dev.helw.playground.sdui.model.Renderer
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
    override val identifier: String
) : Component {

    override fun provideRenderer(): Renderer {
        return provideRendererProvider().provideListItemRenderer(
            title = title,
            description = description,
            leading = leading,
            trailing = trailing,
            backgroundColor = backgroundColor)
    }
}