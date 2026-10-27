package conventionplugins.project

import extensions.commonMainDependencies
import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class KmpComposeLibraryPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("kmp.library.plugin")
                apply("kmp.compose.config")
            }

            commonMainDependencies {
                implementation(libs.androidx.lifecycle.viewmodelCompose)
                implementation(libs.androidx.lifecycle.runtimeCompose)
            }
        }
    }
}