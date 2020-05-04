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

  val json = Json(JsonConfiguration.Stable)

  //val jsonData = json.stringify(ChannelCount.serializer(), tri)
}
