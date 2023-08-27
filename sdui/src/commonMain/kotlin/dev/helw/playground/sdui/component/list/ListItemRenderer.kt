package dev.helw.playground.sdui.component.list

import dev.helw.playground.sdui.design.core.IconToken
import dev.helw.playground.sdui.design.core.SizeToken
import dev.helw.playground.sdui.design.core.TypographyToken
import dev.helw.playground.sdui.serializer.model.BackgroundColorToken

interface ListItemRenderer {
    fun provideListItemContentTitleRenderer(text: String): ListItemContentTitleRenderer
    fun provideListItemContentDescriptionRenderer(text: String): ListItemContentDescriptionRenderer
    fun provideListItemLeadingRendererProvider(): ListItemLeadingRendererProvider
    fun provideListItemTrailingRendererProvider(): ListItemTrailingRendererProvider
}

expect interface ListItemContentTitleRenderer
expect interface ListItemContentDescriptionRenderer

expect interface ListItemLeadingRenderer

interface ListItemLeadingRendererProvider {
    fun provideListItemLetterCircleRenderer(
        text: String,
        size: SizeToken,
        typography: TypographyToken,
        backgroundColor: BackgroundColorToken
    ): ListItemLeadingRenderer

    fun provideListItemNetworkImageRenderer(
        url: String,
        contentDescription: String
    ): ListItemLeadingRenderer
}

expect interface ListItemTrailingRenderer

interface ListItemTrailingRendererProvider {
    fun provideListItemTrailingDetailRenderer(text: String): ListItemTrailingRenderer
    fun provideListItemTrailingStatusIconRenderer(
        icon: IconToken,
        size: SizeToken
    ): ListItemTrailingRenderer
}