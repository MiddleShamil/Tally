import extensions.kotlinJvmCompilerOptions
import extensions.libs
import extensions.projectJavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.kotlin.multiplatform.library")

    id("org.jetbrains.kotlin.multiplatform")
}

kotlin {
    android {
        compileSdk = libs.versions.compileSdk.get().toInt()
        minSdk = libs.versions.minSdk.get().toInt()
    }
    iosArm64()
    iosSimulatorArm64()
}

kotlinJvmCompilerOptions { jvmTarget = JvmTarget.fromTarget(projectJavaVersion.toString()) }