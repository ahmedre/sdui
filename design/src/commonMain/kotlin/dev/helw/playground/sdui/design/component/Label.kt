package dev.helw.playground.sdui.design.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dev.helw.playground.sdui.design.core.TextColor
import dev.helw.playground.sdui.design.core.TypographyToken

@Composable
fun Label(text: String, typographyToken: TypographyToken, textColor: TextColor) {
    Text(
        text = text,
        style = typographyToken.textStyle,
        color = textColor.color
    )
}