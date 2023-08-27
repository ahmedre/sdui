package dev.helw.playground.sdui.component

import dev.helw.playground.sdui.model.Component
import dev.helw.playground.sdui.model.Renderer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("list")
class ListComponent(
    private val contents: List<Component>,
    override val identifier: String
) : Component {

    override fun provideRenderer(): Renderer {
        return provideRendererProvider().provideListRenderer(contents)
    }
}