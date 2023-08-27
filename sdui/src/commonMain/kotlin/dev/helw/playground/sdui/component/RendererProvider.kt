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
import dev.helw.playground.sdui.serializer.model.BackgroundColorToken
import dev.helw.playground.sdui.serializer.model.TextColorToken

expect fun provideRendererProvider(): RendererProvider

interface RendererProvider {
    fun provideAsyncImageRenderer(url: String, description: String): Renderer

    fun provideIconRenderer(icon: IconToken, size: SizeToken): Renderer

    fun provideLabelRenderer(
        text: String,
        typography: TypographyToken,
        color: TextColorToken
    ): Renderer

    fun provideListRenderer(components: List<Component>): Renderer

    fun provideListItemRenderer(
        title: ListItemContentTitle,
        description: ListItemContentDescription?,
        leading: ListItemLeading?,
        trailing: ListItemTrailing?,
        backgroundColor: BackgroundColorToken?
    ): Renderer
}