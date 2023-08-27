plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrain.compose)
}

compose {
    kotlinCompilerPlugin = dependencies.compiler.forKotlin("1.9.0")
    kotlinCompilerPluginArgs.add("suppressKotlinVersionCompatibilityCheck=1.9.10")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    jvm("desktop")

    js(IR) { browser() }

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

        val composeMain by creating {
            dependencies {
                dependsOn(commonMain)
            }
        }

        val androidMain by getting {
            dependencies {
                dependsOn(composeMain)
                implementation(libs.coil.compose)
            }
        }

        val desktopMain by getting {
            dependencies {
                dependsOn(composeMain)
            }
        }

        val jsMain by getting {
            dependencies {
                dependsOn(composeMain)
            }
        }
    }
}

android {
    namespace = "dev.helw.playground.sdui"
    compileSdk = 34
    defaultConfig.minSdk = 21
}