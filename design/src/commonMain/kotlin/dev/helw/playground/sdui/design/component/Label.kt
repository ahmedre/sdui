package dev.helw.playground.sdui.design.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import dev.helw.playground.sdui.design.core.TextColor
import dev.helw.playground.sdui.design.core.TypographyToken

@Composable
fun Label(
    text: String,
    typographyToken: TypographyToken,
    textColor: TextColor,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = typographyToken.textStyle,
        color = textColor.color,
        overflow = overflow,
        maxLines = maxLines,
        modifier = modifier
    )
}