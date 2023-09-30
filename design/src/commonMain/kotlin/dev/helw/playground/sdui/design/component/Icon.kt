/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.design.component

import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.design.core.IconToken
import dev.helw.playground.sdui.design.core.SizeToken

@Composable
fun Icon(iconToken: IconToken, sizeToken: SizeToken = SizeToken.MEDIUM, contentDescription: String? = null, modifier: Modifier = Modifier) {
    androidx.compose.material3.Icon(
        imageVector = iconToken.image,
        contentDescription = contentDescription,
        modifier = modifier.requiredSize(sizeToken.underlyingSize)
    )
}
