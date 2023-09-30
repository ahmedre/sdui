/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
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
