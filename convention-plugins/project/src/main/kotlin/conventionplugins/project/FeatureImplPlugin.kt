package conventionplugins.project

import extensions.commonMainDependencies
import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class FeatureImplPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("kmp.compose.library.plugin")
                apply("kmp.coroutines.plugin")
                apply("kmp.koin.plugin")
                apply("kmp.serialization.plugin")
            }

            commonMainDependencies {
                implementation(libs.androidx.navigation.compose)

                implementation(project(path.substringBeforeLast(':') + ":api"))
                implementation(project(":core:domain"))
                implementation(project(":core:ui"))
                implementation(project(":core:logging"))
            }
        }
    }
}