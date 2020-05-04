package io.arrowkt.example

import kotlinx.serialization.*

@Serializable(with = SampleRateHzSerializer::class)
data class SampleRateHz(val value : Int) {
    override fun toString(): String = "$value hz"
}

@Serializer(forClass = SampleRateHz::class)
class SampleRateHzSerializer : KSerializer<SampleRateHz> {
    override val descriptor: SerialDescriptor =
        PrimitiveDescriptor(SampleRateHz::class.java.simpleName, PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: SampleRateHz) {
        encoder.encodeInt(value.value)
    }

    override fun deserialize(decoder: Decoder): SampleRateHz {
        return SampleRateHz(decoder.decodeInt())
    }
}
