/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrain.compose)
    alias(libs.plugins.kotlin.compose)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    applyDefaultHierarchyTemplate()

    jvm("desktop")

    js(IR) { browser() }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs { browser() }

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.design)
                implementation(compose.ui)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(libs.kotlinx.serialization.json)
            }
        }
    }
}

android {
    namespace = "dev.helw.playground.sdui"
    compileSdk = 34
    defaultConfig.minSdk = 21
}