package dev.helw.playground.sdui.component

import androidx.compose.runtime.Composable
import dev.helw.playground.sdui.Component
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("label")
class LabelComponent(
    private val text: String,
    override val type: String
) : Component {

    @Composable
    override fun asComposable() {
    }
}