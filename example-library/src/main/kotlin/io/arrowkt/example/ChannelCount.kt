package io.arrowkt.example

//metadebug

@InlineSerializable
data class ChannelCount(val value : Int) {
  override fun toString(): String = "$value channels"

  operator fun plus(other : ChannelCount) =
      ChannelCount(value + other.value)
}
