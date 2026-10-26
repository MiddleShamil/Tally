package extensions

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.CompileOptions
import com.android.build.api.dsl.DefaultConfig
import com.android.build.api.dsl.LibraryExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.the
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompilerOptions
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

private val Project.androidExtension: CommonExtension
    get() = extensions.findByType(ApplicationExtension::class)
        ?: extensions.findByType(LibraryExtension::class)
        ?: error(
            "\"Project.androidExtension\" value may be called only from android application" +
                    " or android library gradle script"
        )

val Project.libs: LibrariesForLibs
    get() = the<LibrariesForLibs>()

val Project.projectJavaVersion: JavaVersion
    get() = JavaVersion.toVersion(libs.versions.java.get().toInt())

fun Project.androidConfig(block: CommonExtension.() -> Unit): Unit = block(androidExtension)

fun Project.androidDefaultConfig(block: DefaultConfig.() -> Unit) {
    extensions.findByType<ApplicationExtension>()?.defaultConfig(block)
        ?: extensions.findByType<LibraryExtension>()?.defaultConfig(block)
        ?: error(
            "\"Project.androidDefaultConfig\" may be called only from android application" +
                    " or android library gradle script"
        )
}

fun Project.androidCompileOptions(block: CompileOptions.() -> Unit) {
    extensions.findByType<ApplicationExtension>()?.compileOptions(block)
        ?: extensions.findByType<LibraryExtension>()?.compileOptions(block)
        ?: error(
            "\"Project.androidCompileOptions\" may be called only from android application" +
                    " or android library gradle script"
        )
}

fun Project.kotlinJvmCompilerOptions(block: KotlinJvmCompilerOptions.() -> Unit) {
    tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions(block)
    }
}