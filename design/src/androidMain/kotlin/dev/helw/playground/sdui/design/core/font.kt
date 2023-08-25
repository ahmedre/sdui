package dev.helw.playground.sdui.design.core

import androidx.compose.ui.text.EmojiSupportMatch
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import dev.helw.playground.sdui.design.R

private val InterFontFamily = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold),
)

internal actual val fontFamily: FontFamily = InterFontFamily

internal actual val platformTextStyle: PlatformTextStyle = PlatformTextStyle(emojiSupportMatch = EmojiSupportMatch.Default)