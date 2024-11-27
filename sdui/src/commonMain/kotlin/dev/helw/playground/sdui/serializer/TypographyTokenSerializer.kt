/**
 * Copyright (c) 2024 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.serializer

import dev.helw.playground.sdui.design.core.TypographyToken
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object TypographyTokenSerializer : KSerializer<TypographyToken> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("TypographyToken", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: TypographyToken) {
        encoder.encodeString(value.name)
    }

    override fun deserialize(decoder: Decoder): TypographyToken {
        val tokenString = decoder.decodeString()
        return TypographyToken.values.find { it.name == tokenString } ?: TypographyToken.Body.Medium
    }
}
