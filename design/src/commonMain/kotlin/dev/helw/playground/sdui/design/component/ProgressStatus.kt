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

@Composable
fun ProgressStatus(amount: Int, total: Int, size: SizeToken) {
    Box(contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            progress = amount.toFloat() / total.toFloat(),
            modifier = Modifier.size(size.underlyingSize * 2),
            trackColor = LocalBackgroundColors.current.tertiary.color,
            color = LocalBackgroundColors.current.onTertiary.color
        )

        val typography = size.toTypographyToken().textStyle
        Text("$amount/$total", style = typography)
    }
}

private fun SizeToken.toTypographyToken() = when (this) {
    SizeToken.SMALL -> TypographyToken.Label.Small
    SizeToken.MEDIUM -> TypographyToken.Label.Medium
    SizeToken.LARGE -> TypographyToken.Label.Large
}