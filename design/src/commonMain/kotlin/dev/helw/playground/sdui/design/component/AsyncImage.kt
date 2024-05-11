/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.design.component

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import dev.helw.playground.sdui.design.core.SizeToken

@Composable
fun AsyncImage(url: String, contentDescription: String, size: SizeToken, modifier: Modifier) {
    coil3.compose.AsyncImage(
        model = ImageRequest.Builder(LocalPlatformContext.current)
            .data(url)
            .build(),
        contentDescription = contentDescription,
        modifier = modifier.size(size.underlyingSize)
    )
}
