package io.arrowkt.example

val InlineClass.serializerClassSource get() =
    """ |package $serializerClassPackageName
        |
        |import kotlinx.serialization.*
        |
        |import $fullyQualifiedName
        |
        |@Serializer(forClass = ${name}::class)
        |class $serializerClassName : KSerializer<${name}> {
        |    override val descriptor: SerialDescriptor =
        |        PrimitiveDescriptor("$name", PrimitiveKind.$primitiveKindName)
        |
        |    override fun serialize(encoder: Encoder, value: $name) {
        |        encoder.encode$valueParameterTypeName(value.value)
        |    }
        |
        |    override fun deserialize(decoder: Decoder): $name {
        |        return $name(decoder.decode$valueParameterTypeName())
        |    }
        |}
    """.trimMargin()

val InlineClass.decoratedClassSource get() =
    """ |@kotlinx.serialization.Serializable(with = $serializerClassPackageName.$serializerClassName::class)
        |""".trimMargin() +
    originalClassSourceCode

val InlineClass.serializerSourceFilename get() =
    "${name}.inline_serialization.kt"
