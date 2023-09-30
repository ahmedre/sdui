/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.serializer.model

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ShapeToken(val underlyingShape: Shape) {
    @SerialName("rectangle") RECTANGLE(RectangleShape),
    @SerialName("roundedCorners") ROUNDED_CORNERS(RoundedCornerShape(8.dp))
}
