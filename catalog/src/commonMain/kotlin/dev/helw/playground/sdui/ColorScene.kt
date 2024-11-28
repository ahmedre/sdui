/**
 * Copyright (c) 2024 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import dev.helw.playground.sdui.design.component.Label
import dev.helw.playground.sdui.design.core.TextColor
import dev.helw.playground.sdui.design.core.TypographyToken
import dev.helw.playground.sdui.design.core.color.LocalBackgroundColors
import dev.helw.playground.sdui.design.core.color.LocalTextColors
import dev.helw.playground.sdui.design.core.color.withNames

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun ColorScene(modifier: Modifier = Modifier) {
    val textColors = LocalTextColors.current.withNames()
    val backgroundColors = LocalBackgroundColors.current.withNames()
    LazyColumn(modifier = modifier) {
        item {
            ColorTitle("Background colors")
            FlowRow {
                backgroundColors.forEach {
                    ColorContainer(it.first, modifier = Modifier.background(it.second.color))
                }
            }
        }

        item {
            ColorTitle("Text colors")
            FlowRow {
                textColors.forEach {
                    ColorContainer(
                        colorName = it.first,
                        textColor = with(LocalTextColors.current) {
                            if (it.first == "primaryInverse") primary else primaryInverse
                        },
                        modifier = Modifier.background(it.second.color)
                    )
                }
            }
        }
    }

}

@Composable
private fun ColorTitle(title: String) {
    Label(
        text = title,
        typographyToken = TypographyToken.Headline.Medium,
        textColor = LocalTextColors.current.primary
    )
}

@Composable
private fun ColorContainer(
    colorName: String,
    textColor: TextColor = LocalTextColors.current.primary,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RectangleShape
            )
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Label(
            text = colorName,
            typographyToken = TypographyToken.Body.Medium,
            textColor = textColor
        )
    }
}


/**
 * A shape describing the rectangle.
 */
@Stable
val RectangleShape: Shape = object : Shape {
    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density) =
        Outline.Rectangle(size.toRect())

    override fun toString(): String = "RectangleShape"
}
