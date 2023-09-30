/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.model

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp
import dev.helw.playground.sdui.serializer.model.BackgroundColorToken
import dev.helw.playground.sdui.serializer.model.ShapeToken
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class SduiModifier {

    @Serializable
    @SerialName("background")
    class Background(
        val color: BackgroundColorToken,
        val alpha: Float = 1f,
        val shape: ShapeToken = ShapeToken.RECTANGLE
    ) : SduiModifier()

    @Serializable
    @SerialName("padding")
    class Padding(
        val start: Int = 0,
        val end: Int = 0,
        val top: Int = 0,
        val bottom: Int = 0
    ) : SduiModifier()
}

fun Modifier.applyModifiers(modifiers: List<SduiModifier>) = composed {
    modifiers.fold(this) { acc, sduiModifier ->
        acc.applyModifier(sduiModifier)
    }
}

private fun Modifier.applyModifier(sduiModifier: SduiModifier) = composed {
    when (sduiModifier) {
        is SduiModifier.Background -> this.background(
            sduiModifier.color.colorValue().color.copy(
                alpha = sduiModifier.alpha
            ),
            sduiModifier.shape.underlyingShape
        )

        is SduiModifier.Padding -> this.padding(
            sduiModifier.start.dp,
            sduiModifier.top.dp,
            sduiModifier.end.dp,
            sduiModifier.bottom.dp
        )
    }
}
