package dev.helw.playground.sdui.component

import androidx.compose.runtime.Composable
import dev.helw.playground.sdui.Component
import dev.helw.playground.sdui.design.component.Label
import dev.helw.playground.sdui.design.core.TypographyToken
import dev.helw.playground.sdui.model.TextColorToken
import dev.helw.playground.sdui.serializer.TypographyTokenSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("label")
class LabelComponent(
    private val text: String,
    @Serializable(with = TypographyTokenSerializer::class)
    private val typography: TypographyToken,
    private val color: TextColorToken,
    override val type: String
) : Component {

    @Composable
    override fun Content() {
        Label(
            text = text,
            typographyToken = typography,
            textColor = color.colorValue()
        )
    }
}