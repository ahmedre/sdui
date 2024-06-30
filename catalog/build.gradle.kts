/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrain.compose)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    applyDefaultHierarchyTemplate()

    jvm("desktop")

    js(IR) {
        moduleName = "catalog"
        browser()
        binaries.executable()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            commonWebpackConfig {
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        add(project.projectDir.path)
                    }
                }
            }
        }
        binaries.executable()
    }

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
                implementation(projects.sdui)
                implementation(compose.ui)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(libs.kotlinx.serialization.json)

                implementation(libs.ktor.client.core)
                implementation(libs.ktor.serialization.json)
                implementation(libs.ktor.client.contentNegotiation)
                implementation(libs.ktor.client.logging)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.compose.ui)
                implementation(libs.androidx.compose.ui.tooling)
                implementation(libs.androidx.compose.ui.tooling.preview)
                implementation(libs.androidx.compose.foundation)
                implementation(libs.androidx.compose.material)
                implementation(libs.androidx.activity.compose)
                implementation(libs.androidx.navigation.compose)
                implementation(libs.ktor.client.okhttp)
            }
        }

        val desktopMain by getting {
            resources.srcDir("src/commonRes")
            dependencies {
                implementation(compose.ui)
                implementation(compose.desktop.currentOs)
                implementation(libs.ktor.client.okhttp)
            }
        }

        val jsMain by getting {
            resources.srcDirs("src/commonRes", "../sdui/src/commonRes")
            dependencies {
                implementation(projects.design)
                implementation(compose.ui)
                implementation(libs.ktor.client.js)
            }
        }

        val wasmJsMain by getting {
            dependsOn(commonMain)
            resources.srcDirs("src/commonRes", "../sdui/src/commonRes")
            dependencies {
                implementation(projects.design)
                implementation(compose.ui)

                val wasmKtor = "3.0.0-wasm1"
                implementation("io.ktor:ktor-client-core:$wasmKtor")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$wasmKtor")
                implementation("io.ktor:ktor-client-content-negotiation:$wasmKtor")
                implementation("io.ktor:ktor-client-logging:$wasmKtor")
            }
        }
    }
}

android {
    namespace = "dev.helw.playground.sdui.android"
    compileSdk = 34

    sourceSets {
        getByName("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDir("src/commonRes")
        }
    }

    defaultConfig {
        applicationId = "dev.helw.playground.sdui.android"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

compose {
    desktop.application {
        mainClass = "dev.helw.playground.sdui.DesktopDemoAppKt"
        nativeDistributions {
            packageName = "DesktopDemoApp"
            macOS.bundleID = "dev.helw.playground.sdui"
        }
    }

    experimental.web.application {}
}