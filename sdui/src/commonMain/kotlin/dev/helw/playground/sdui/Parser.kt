package dev.helw.playground.sdui

import dev.helw.playground.sdui.component.LabelComponent
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.PolymorphicModuleBuilder
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

object Parser {
    private val componentModule = SerializersModule {
        fun PolymorphicModuleBuilder<Component>.registerProjectSubclasses() {
            subclass(LabelComponent::class)
        }

        polymorphic(Component::class) { registerProjectSubclasses() }
    }

    private val json = Json {
        classDiscriminator = "type"
        serializersModule = componentModule
    }

    fun parse(data: String): Component {
        return json.decodeFromString(data)
    }
}