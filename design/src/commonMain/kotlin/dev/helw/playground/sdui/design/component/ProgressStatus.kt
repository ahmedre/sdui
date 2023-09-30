/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.design.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.design.core.SizeToken
import dev.helw.playground.sdui.design.core.TypographyToken
import dev.helw.playground.sdui.design.core.color.LocalBackgroundColors
import dev.helw.playground.sdui.design.core.color.LocalTextColors

@Composable
fun ProgressStatus(amount: Int, total: Int, size: SizeToken, modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier) {
        CircularProgressIndicator(
            progress = amount.toFloat() / total.toFloat(),
            modifier = Modifier.size(size.underlyingSize * 2),
            trackColor = LocalBackgroundColors.current.tertiary.color,
            color = LocalBackgroundColors.current.onTertiary.color
        )

        val typography = size.toTypographyToken()
        Label("$amount/$total", typographyToken = typography, LocalTextColors.current.primary)
    }
}

private fun SizeToken.toTypographyToken() = when (this) {
    SizeToken.SMALL -> TypographyToken.Label.Small
    SizeToken.MEDIUM -> TypographyToken.Label.Medium
    SizeToken.LARGE -> TypographyToken.Label.Large
}
