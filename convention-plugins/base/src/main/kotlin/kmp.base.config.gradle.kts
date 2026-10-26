import extensions.kotlinJvmCompilerOptions
import extensions.libs
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.kotlin.multiplatform.library")

    id("org.jetbrains.kotlin.multiplatform")
}

kotlin {
    android {
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    iosArm64()
    iosSimulatorArm64()
}

kotlinJvmCompilerOptions { jvmTarget = JvmTarget.fromTarget(libs.versions.java.get()) }