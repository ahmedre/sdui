package dev.helw.playground.sdui.design.component.listitem

sealed interface ListItemScope {
    data object Leading : ListItemScope {
    }

    interface Content : ListItemScope {
        data object Title : Content {
        }

        data object Description : Content {
        }
    }

    data object Trailing : ListItemScope {
    }
}