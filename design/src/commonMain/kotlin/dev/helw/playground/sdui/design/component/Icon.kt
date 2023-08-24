package dev.helw.playground.sdui.design.component

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.design.core.IconToken
import dev.helw.playground.sdui.design.core.SizeToken

@Composable
fun Icon(iconToken: IconToken, sizeToken: SizeToken = SizeToken.MEDIUM, contentDescription: String? = null) {
    androidx.compose.material3.Icon(
        imageVector = iconToken.image,
        contentDescription = contentDescription,
        modifier = Modifier.size(sizeToken.underlyingSize)
    )
}