package dev.helw.playground.sdui

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform