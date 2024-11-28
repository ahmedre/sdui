/**
 * Copyright (c) 2024 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.design.core

import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import org.jetbrains.skiko.loadBytesFromPath

private var InterFontFamily: FontFamily = FontFamily.Default

suspend fun initializeFonts() {
    InterFontFamily = loadInterFont()
}

private suspend fun loadInterFont(): FontFamily {
    return FontFamily(
        Font("inter_normal", data = loadBytesFromPath("font/inter_regular.otf"), FontWeight.Normal),
        Font("inter_medium", data = loadBytesFromPath("font/inter_medium.otf"), FontWeight.Medium),
        Font("inter_semibold", data = loadBytesFromPath("font/inter_semibold.otf"), FontWeight.SemiBold),
        Font("inter_bold", data = loadBytesFromPath("font/inter_bold.otf"), FontWeight.Bold),
    )
}

internal actual val platformTextStyle: PlatformTextStyle = PlatformTextStyle(null, null)
internal actual val fontFamily: FontFamily = InterFontFamily
