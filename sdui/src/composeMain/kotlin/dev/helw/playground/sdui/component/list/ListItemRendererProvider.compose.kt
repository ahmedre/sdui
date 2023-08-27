package dev.helw.playground.sdui.component.list

actual fun provideListItemRendererProvider(): ListItemRenderer {
    return object : ListItemRenderer {
        override fun provideListItemContentTitleRenderer(text: String): ListItemContentTitleRenderer {
            return ListItemContentTitleRendererImpl(text)
        }

        override fun provideListItemContentDescriptionRenderer(text: String): ListItemContentDescriptionRenderer {
            return ListItemContentDescriptionRendererImpl(text)
        }

        override fun provideListItemLeadingRendererProvider(): ListItemLeadingRendererProvider {
            return ListItemLeadingRendererImpl()
        }

        override fun provideListItemTrailingRendererProvider(): ListItemTrailingRendererProvider {
            return ListItemTrailingRendererProviderImpl()
        }
    }
}
