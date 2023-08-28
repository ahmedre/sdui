package dev.helw.playground.sdui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.helw.playground.sdui.design.component.Icon
import dev.helw.playground.sdui.design.component.Label
import dev.helw.playground.sdui.design.core.IconToken
import dev.helw.playground.sdui.design.core.SizeToken
import dev.helw.playground.sdui.design.core.TypographyToken
import dev.helw.playground.sdui.design.core.color.LocalTextColors

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun IconScene(modifier: Modifier = Modifier) {
    FlowRow(modifier = modifier) {
        IconToken.entries.forEach {
            Column(modifier = Modifier.padding(8.dp)) {
                Label(
                    it.name,
                    typographyToken = TypographyToken.Body.Medium,
                    textColor = LocalTextColors.current.primary,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Icon(
                    iconToken = it,
                    sizeToken = SizeToken.MEDIUM,
                    contentDescription = it.name
                )
            }
        }
    }
}