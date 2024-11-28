/**
 * Copyright (c) 2024 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.helw.playground.sdui.design.component.Icon
import dev.helw.playground.sdui.design.component.Label
import dev.helw.playground.sdui.design.core.IconToken
import dev.helw.playground.sdui.design.core.SizeToken
import dev.helw.playground.sdui.design.core.TypographyToken
import dev.helw.playground.sdui.design.core.color.LocalTextColors

@Composable
internal fun SizeScene(modifier: Modifier = Modifier) {
    var currentSelection by remember { mutableStateOf(SizeToken.entries.first()) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                iconToken = IconToken.HOME,
                sizeToken = currentSelection,
                contentDescription = currentSelection.name
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = {
                        val currentIndex = SizeToken.entries.indexOf(currentSelection)
                        currentSelection = SizeToken.entries.getOrNull(currentIndex - 1)
                            ?: SizeToken.entries.last()
                    }
                ) {
                    Icon(
                        iconToken = IconToken.ARROW_BACK,
                        sizeToken = SizeToken.MEDIUM,
                        contentDescription = "Previous"
                    )
                }

                Label(
                    currentSelection.name,
                    typographyToken = TypographyToken.Body.Medium,
                    textColor = LocalTextColors.current.primary,
                    modifier = Modifier.padding(top = 16.dp)
                )

                IconButton(
                    onClick = {
                        val currentIndex = SizeToken.entries.indexOf(currentSelection)
                        currentSelection = SizeToken.entries.getOrNull(currentIndex + 1)
                            ?: SizeToken.entries.first()
                    }
                ) {
                    Icon(
                        iconToken = IconToken.ARROW_FORWARD,
                        sizeToken = SizeToken.MEDIUM,
                        contentDescription = "Next"
                    )
                }
            }
        }
    }
}
