package dev.helw.playground.sdui.component

import androidx.compose.runtime.Composable
import dev.helw.playground.sdui.Component
import dev.helw.playground.sdui.design.component.AsyncImage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("asyncImage")
class AsyncImageComponent(
    private val url: String,
    private val contentDescription: String,
    override val type: String
) : Component {

    @Composable
    override fun Content() {
        AsyncImage(url, contentDescription)
    }
}