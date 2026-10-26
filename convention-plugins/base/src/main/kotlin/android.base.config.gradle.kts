import extensions.androidCompileOptions
import extensions.androidConfig
import extensions.androidDefaultConfig
import extensions.kotlinJvmCompilerOptions
import extensions.libs
import extensions.projectJavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

androidConfig {
    compileSdk = libs.versions.android.compileSdk.get().toInt()
}

androidDefaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
}

androidCompileOptions {
    sourceCompatibility = projectJavaVersion
    targetCompatibility = projectJavaVersion
}

kotlinJvmCompilerOptions {
    jvmTarget.set(JvmTarget.fromTarget(projectJavaVersion.toString()))
    freeCompilerArgs.add("-Xjdk-release=${projectJavaVersion}")
}