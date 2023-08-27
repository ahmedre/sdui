package dev.helw.playground.sdui.component

import dev.helw.playground.sdui.model.Component
import dev.helw.playground.sdui.model.Renderer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("asyncImage")
class AsyncImageComponent(
    private val url: String,
    private val contentDescription: String,
    override val identifier: String
) : Component {

    override fun provideRenderer(): Renderer =
        provideRendererProvider().provideAsyncImageRenderer(url, contentDescription)
}