package dev.helw.playground.sdui.parser

import dev.helw.playground.sdui.action.Action
import dev.helw.playground.sdui.action.OnClick
import dev.helw.playground.sdui.action.OnViewed
import dev.helw.playground.sdui.component.AsyncImageComponent
import dev.helw.playground.sdui.component.IconComponent
import dev.helw.playground.sdui.component.LabelComponent
import dev.helw.playground.sdui.component.ListComponent
import dev.helw.playground.sdui.component.ListItemComponent
import dev.helw.playground.sdui.component.ProgressStatusComponent
import dev.helw.playground.sdui.component.core.ColumnComponent
import dev.helw.playground.sdui.component.core.RowComponent
import dev.helw.playground.sdui.model.Component
import dev.helw.playground.sdui.model.ServerDrivenUiResponse
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.PolymorphicModuleBuilder
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.SerializersModuleBuilder
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

class ServerDrivenUiSerializer internal constructor(
    private val componentModuleBuilder: PolymorphicModuleBuilder<Component>.() -> Unit,
    private val actionModuleBuilder: PolymorphicModuleBuilder<Action>.() -> Unit,
) {
    private val componentModule = SerializersModule {
        fun SerializersModuleBuilder.registerComponents() {
            polymorphic(Component::class) {
                subclass(ListComponent::class)
                subclass(ListItemComponent::class)
                subclass(LabelComponent::class)
                subclass(IconComponent::class)
                subclass(AsyncImageComponent::class)
                subclass(ProgressStatusComponent::class)
                componentModuleBuilder(this)

                // primitives
                subclass(RowComponent::class)
                subclass(ColumnComponent::class)
            }
        }

        fun SerializersModuleBuilder.registerActions() {
            polymorphic(Action::class) {
                subclass(OnClick.Deeplink::class)
                subclass(OnClick.InteractionEvent::class)
                subclass(OnViewed.ImpressionEvent::class)
                actionModuleBuilder(this)
            }
        }
        registerComponents()
        registerActions()
    }

    private val json = Json {
        serializersModule = componentModule
    }

    fun parse(data: String): ServerDrivenUiResponse {
        return json.decodeFromString(data)
    }

    companion object {
        val default = Builder().build()
    }

    class Builder {
        private var componentModuleBuilder: PolymorphicModuleBuilder<Component>.() -> Unit = {}
        private var actionModuleBuilder: PolymorphicModuleBuilder<Action>.() -> Unit = {}

        fun addComponentSubclasses(block: PolymorphicModuleBuilder<Component>.() -> Unit) {
            componentModuleBuilder = block
        }

        fun addActionSubclasses(block: PolymorphicModuleBuilder<Action>.() -> Unit) {
            actionModuleBuilder = block
        }

        fun build(): ServerDrivenUiSerializer = ServerDrivenUiSerializer(
            componentModuleBuilder = componentModuleBuilder,
            actionModuleBuilder = actionModuleBuilder
        )
    }
}