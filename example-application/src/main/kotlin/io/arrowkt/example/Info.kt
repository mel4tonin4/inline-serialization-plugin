package io.arrowkt.example

import kotlinx.serialization.Serializable

@Serializable
data class Info(
    val channelCount: ChannelCount,
    val sampleRate: SampleRateHz
)
