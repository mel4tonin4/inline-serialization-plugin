package com.github.mel4tonin4.example.arrow_meta.inline_serialization.example_application

import kotlinx.serialization.Serializable

import com.github.mel4tonin4.example.arrow_meta.inline_serialization.example_library.ChannelCount

@Serializable
data class Info(
        val channelCount: ChannelCount,
        val sampleRate: SampleRateHz
)
