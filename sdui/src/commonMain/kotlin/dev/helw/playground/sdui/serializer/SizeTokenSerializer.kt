/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.serializer

import dev.helw.playground.sdui.design.core.SizeToken
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class SizeTokenSerializer : KSerializer<SizeToken> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("SizeToken", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: SizeToken) {
        encoder.encodeString(value.name.lowercase())
    }

    override fun deserialize(decoder: Decoder): SizeToken {
        val tokenString = decoder.decodeString().lowercase()
        return SizeToken.entries
            .find { it.name.lowercase() == tokenString } ?: SizeToken.MEDIUM
    }
}
