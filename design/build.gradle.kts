plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrain.compose)
}

compose {
    kotlinCompilerPlugin = libs.androidx.compose.compiler.map { it.toString() }
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
                implementation(compose.ui)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.coil.compose)
                implementation(compose.uiTooling)
            }
        }

        val desktopMain by getting {
            resources.srcDir("src/commonRes")
        }

        val jsMain by getting {
            dependencies {
                implementation(compose.ui)
                implementation(compose.material)
                implementation(compose.foundation)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
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