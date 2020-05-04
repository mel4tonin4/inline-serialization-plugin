package io.arrowkt.example

import org.jetbrains.kotlin.psi.*

import arrow.core.getOrHandle
import arrow.meta.CliPlugin
import arrow.meta.Meta
import arrow.meta.invoke
import arrow.meta.quotes.Transform
import arrow.meta.quotes.classDeclaration
import arrow.meta.quotes.plus

val Meta.inlineSerialization: CliPlugin
    get() =
        "Inline Serialization" {
            meta(
                classDeclaration({ isAnnotatedWith<InlineSerializable>() } ) { c ->
                    val inlineClass = InlineClass.tryMake(c).getOrHandle {  problem ->
                        throw when (problem) {
                            InlineClass.Problem.WrongStructure ->
                                IllegalArgumentException("inline serialization is meaningful only for classes with one and only one val member")
                            is InlineClass.Problem.UnsupportedType ->
                                IllegalArgumentException("unsupported val member type $problem.valueParameterTypeName: Only supported types are: ${allPrimitiveKinds.keys.joinToString { it.toLowerCase().capitalize() }}")
                        }
                    }

                    val originalClassDecoration = Transform.replace<KtClass>(
                        replacing = c,
                        newDeclaration = inlineClass.decoratedClassSource.`class`.syntheticScope
                    )
                    val serializerClassGeneration = Transform.newSources<KtClass>(
                        inlineClass.serializerClassSource.file(inlineClass.serializerSourceFilename)
                    )

                    originalClassDecoration + serializerClassGeneration
                    //serializerClassGeneration
                }
            )
        }
