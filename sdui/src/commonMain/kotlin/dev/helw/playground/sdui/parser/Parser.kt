package dev.helw.playground.sdui.parser

import dev.helw.playground.sdui.action.Action
import dev.helw.playground.sdui.component.AsyncImageComponent
import dev.helw.playground.sdui.component.IconComponent
import dev.helw.playground.sdui.component.LabelComponent
import dev.helw.playground.sdui.component.ListComponent
import dev.helw.playground.sdui.model.Component
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.SerializersModuleBuilder
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

object Parser {
    private val componentModule = SerializersModule {
        fun SerializersModuleBuilder.registerComponents() {
            polymorphic(Component::class) {
                subclass(ListComponent::class)
                subclass(LabelComponent::class)
                subclass(IconComponent::class)
                subclass(AsyncImageComponent::class)
            }
        }

        fun SerializersModuleBuilder.registerActions() {
            polymorphic(Action::class) {
                subclass(Action.OnClick.Deeplink::class)
                subclass(Action.OnViewed.ImpressionEvent::class)
            }
        }
        registerComponents()
        registerActions()
    }

    private val json = Json {
        serializersModule = componentModule
    }

    fun parse(data: String): Component {
        return json.decodeFromString(data)
    }
}