/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
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
