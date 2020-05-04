package io.arrowkt.example

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

fun main() {
  val stereo = ChannelCount(2)
  val mono = ChannelCount(1)
  val tri = stereo + mono

  println(tri)

  val userId1 = UserId.unique()

  println(userId1)


  val sampleRate = SampleRateHz(44100)

  println(sampleRate)

  val json = Json(JsonConfiguration.Stable)

  //println(json.stringify(ChannelCount.serializer(), tri))
  println(json.stringify(SampleRateHz.serializer(), sampleRate))
}
