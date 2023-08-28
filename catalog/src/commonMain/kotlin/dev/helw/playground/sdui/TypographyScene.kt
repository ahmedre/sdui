package dev.helw.playground.sdui

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.helw.playground.sdui.design.component.Label
import dev.helw.playground.sdui.design.core.TypographyToken
import dev.helw.playground.sdui.design.core.color.LocalTextColors

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun TypographyScene(modifier: Modifier = Modifier) {
    FlowRow(modifier = modifier) {
        TypographyToken.values.forEach {
            Label(
                "This is ${it.name}",
                typographyToken = it,
                textColor = LocalTextColors.current.primary,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}