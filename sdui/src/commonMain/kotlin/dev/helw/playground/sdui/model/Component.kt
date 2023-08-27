package dev.helw.playground.sdui.model

interface Component {
    val identifier: String

    fun provideRenderer(): Renderer
}