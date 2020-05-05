package com.github.mel4tonin4.example.arrow_meta.inline_serialization.example_library

import com.github.mel4tonin4.example.arrow_meta.inline_serialization.inline_serialization.InlineSerializable

//metadebug

@InlineSerializable
data class ChannelCount(val value : Int) {
  override fun toString(): String = "$value channels"

  operator fun plus(other : ChannelCount) =
      ChannelCount(value + other.value)
}
