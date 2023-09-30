/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.design.component.ProgressStatus
import dev.helw.playground.sdui.design.core.SizeToken

@Composable
internal fun ProgressStatusScene(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProgressStatus(2, 10, SizeToken.SMALL)
        ProgressStatus(4, 10, SizeToken.MEDIUM)
        ProgressStatus(6, 10, SizeToken.LARGE)
    }
}
