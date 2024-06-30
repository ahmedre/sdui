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
                implementation(compose.ui)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(libs.coil)
                implementation(libs.coil.compose)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.coil.network.okhttp)
                implementation(compose.uiTooling)
            }
        }

        val desktopMain by getting {
            resources.srcDir("src/commonRes")
            dependencies {
                implementation(libs.kotlinx.coroutines.swing)
                implementation(libs.coil.network.okhttp)
            }
        }

        val webMain by creating {
            dependsOn(commonMain)
            dependencies {
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation(libs.coil.network.ktor)
            }
        }

        val jsMain by getting {
            dependsOn(webMain)
            dependencies {
                implementation(libs.ktor.client.js)
                implementation(libs.ktor.client.core)
            }
        }

        val wasmJsMain by getting {
            dependsOn(webMain)
            dependencies {
                val wasmKtor = "3.0.0-wasm1"
                implementation("io.ktor:ktor-client-core:$wasmKtor")
            }
        }
    }
}

android {
    namespace = "dev.helw.playground.sdui.design"
    compileSdk = 34
    defaultConfig.minSdk = 21
    sourceSets {
        named("main") {
            res.srcDir("src/commonRes")
        }
    }
}