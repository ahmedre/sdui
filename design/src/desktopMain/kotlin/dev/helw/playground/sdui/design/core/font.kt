/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.design.core

import androidx.compose.ui.text.PlatformParagraphStyle
import androidx.compose.ui.text.PlatformSpanStyle
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

private val InterFontFamily = FontFamily(
    Font(resource = "font/inter_regular.otf", FontWeight.Normal),
    Font(resource = "font/inter_medium.otf", FontWeight.Medium),
    Font(resource = "font/inter_semibold.otf", FontWeight.SemiBold),
    Font(resource = "font/inter_bold.otf", FontWeight.Bold),
)

internal actual val fontFamily: FontFamily = InterFontFamily
internal actual val platformTextStyle: PlatformTextStyle = PlatformTextStyle(
    spanStyle = PlatformSpanStyle.Default,
    paragraphStyle = PlatformParagraphStyle.Default,
)
