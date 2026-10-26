package extensions

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.CompileOptions
import com.android.build.api.dsl.DefaultConfig
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.the
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompilerOptions
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

private val Project.androidExtension: ApplicationExtension
    get() = extensions.findByType(ApplicationExtension::class)
        ?: error("Android helpers may be called only from android application gradle script")

val Project.libs: LibrariesForLibs
    get() = the<LibrariesForLibs>()

val Project.projectJavaVersion: JavaVersion
    get() = JavaVersion.toVersion(libs.versions.java.get().toInt())

fun Project.androidConfig(block: CommonExtension.() -> Unit): Unit = block(androidExtension)

fun Project.androidDefaultConfig(block: DefaultConfig.() -> Unit) {
    androidExtension.defaultConfig(block)
}

fun Project.androidCompileOptions(block: CompileOptions.() -> Unit) {
    androidExtension.compileOptions(block)
}

fun Project.kotlinJvmCompilerOptions(block: KotlinJvmCompilerOptions.() -> Unit) {
    tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions(block)
    }
}