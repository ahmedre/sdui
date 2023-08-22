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
        return SizeToken.values()
            .find { it.name.lowercase() == tokenString } ?: SizeToken.MEDIUM
    }
}