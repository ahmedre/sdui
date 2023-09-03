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