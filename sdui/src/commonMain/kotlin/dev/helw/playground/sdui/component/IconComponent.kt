package dev.helw.playground.sdui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.model.Component
import dev.helw.playground.sdui.design.component.Icon
import dev.helw.playground.sdui.design.core.IconToken
import dev.helw.playground.sdui.design.core.SizeToken
import dev.helw.playground.sdui.serializer.IconTokenSerializer
import dev.helw.playground.sdui.serializer.SizeTokenSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("icon")
class IconComponent(
    @Serializable(with = IconTokenSerializer::class)
    private val icon: IconToken,
    @Serializable(with = SizeTokenSerializer::class)
    private val size: SizeToken,
    override val type: String,
    override val identifier: String
) : Component {

    @Composable
    override fun Content(modifier: Modifier) {
        Icon(icon, size)
    }
}