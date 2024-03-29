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
    alias(libs.plugins.kotlin.serialization)
}

compose {
    kotlinCompilerPlugin = dependencies.compiler.forKotlin("1.9.21")
    kotlinCompilerPluginArgs.add("suppressKotlinVersionCompatibilityCheck=1.9.22")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    jvm("desktop")

    js(IR) {
        moduleName = "catalog"
        browser()
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
                implementation(libs.coil.compose)
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
    composeOptions.kotlinCompilerExtensionVersion = "1.5.2"

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