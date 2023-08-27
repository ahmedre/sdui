package dev.helw.playground.sdui.component

import dev.helw.playground.sdui.component.list.ListItemContentDescription
import dev.helw.playground.sdui.component.list.ListItemContentTitle
import dev.helw.playground.sdui.component.list.ListItemLeading
import dev.helw.playground.sdui.component.list.ListItemTrailing
import dev.helw.playground.sdui.design.core.IconToken
import dev.helw.playground.sdui.design.core.SizeToken
import dev.helw.playground.sdui.design.core.TypographyToken
import dev.helw.playground.sdui.model.Component
import dev.helw.playground.sdui.model.Renderer
import dev.helw.playground.sdui.model.component.AsyncImageRenderer
import dev.helw.playground.sdui.model.component.IconRenderer
import dev.helw.playground.sdui.model.component.LabelRenderer
import dev.helw.playground.sdui.model.component.ListItemRenderer
import dev.helw.playground.sdui.model.component.ListRenderer
import dev.helw.playground.sdui.serializer.model.BackgroundColorToken
import dev.helw.playground.sdui.serializer.model.TextColorToken

actual fun provideRendererProvider(): RendererProvider {
    return object : RendererProvider {
        override fun provideAsyncImageRenderer(url: String, description: String): Renderer {
            return AsyncImageRenderer(url, description)
        }

        override fun provideIconRenderer(icon: IconToken, size: SizeToken): Renderer {
            return IconRenderer(icon, size)
        }

        override fun provideLabelRenderer(
            text: String,
            typography: TypographyToken,
            color: TextColorToken
        ): Renderer {
            return LabelRenderer(text, typography, color)
        }

        override fun provideListRenderer(components: List<Component>): Renderer {
            return ListRenderer(components)
        }

        override fun provideListItemRenderer(
            title: ListItemContentTitle,
            description: ListItemContentDescription?,
            leading: ListItemLeading?,
            trailing: ListItemTrailing?,
            backgroundColor: BackgroundColorToken?
        ): Renderer {
            return ListItemRenderer(title, description, leading, trailing, backgroundColor)
        }
    }
}
