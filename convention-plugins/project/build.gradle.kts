import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.gradleplugin.android)
    implementation(libs.gradleplugin.compose)
    implementation(libs.gradleplugin.composeCompiler)
    implementation(libs.gradleplugin.kotlin)
    implementation(libs.gradleplugin.kotlinSerialization)
    implementation(libs.gradleplugin.ksp)
    implementation(libs.gradleplugin.room)
    // Workaround for version catalog working inside precompiled scripts
    // Issue - https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))

    implementation(libs.gradleplugin.base)
}

private val projectJavaVersion: JavaVersion = JavaVersion.toVersion(libs.versions.java.get())

java {
    sourceCompatibility = projectJavaVersion
    targetCompatibility = projectJavaVersion
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions.jvmTarget.set(JvmTarget.fromTarget(projectJavaVersion.toString()))
}

gradlePlugin {
    plugins {
        register("android.application.plugin") {
            id = "android.application.plugin"
            implementationClass = "conventionplugins.project.AndroidApplicationPlugin"
        }
        register("kmp.library.plugin") {
            id = "kmp.library.plugin"
            implementationClass = "conventionplugins.project.KmpLibraryPlugin"
        }
        register("kmp.compose.library.plugin") {
            id = "kmp.compose.library.plugin"
            implementationClass = "conventionplugins.project.KmpComposeLibraryPlugin"
        }
        register("kmp.coroutines.plugin") {
            id = "kmp.coroutines.plugin"
            implementationClass = "conventionplugins.project.KmpCoroutinesPlugin"
        }
        register("kmp.serialization.plugin") {
            id = "kmp.serialization.plugin"
            implementationClass = "conventionplugins.project.KmpSerializationPlugin"
        }
        register("kmp.ktor.plugin") {
            id = "kmp.ktor.plugin"
            implementationClass = "conventionplugins.project.KmpKtorPlugin"
        }
        register("kmp.room.plugin") {
            id = "kmp.room.plugin"
            implementationClass = "conventionplugins.project.KmpRoomPlugin"
        }
        register("kmp.koin.plugin") {
            id = "kmp.koin.plugin"
            implementationClass = "conventionplugins.project.KmpKoinPlugin"
        }
        register("feature.api.plugin") {
            id = "feature.api.plugin"
            implementationClass = "conventionplugins.project.FeatureApiPlugin"
        }
        register("feature.impl.plugin") {
            id = "feature.impl.plugin"
            implementationClass = "conventionplugins.project.FeatureImplPlugin"
        }
    }
}