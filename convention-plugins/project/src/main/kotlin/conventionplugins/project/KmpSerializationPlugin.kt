package conventionplugins.project

import extensions.commonMainDependencies
import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class KmpSerializationPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(libs.plugins.kotlinSerialization.get().pluginId)

            commonMainDependencies {
                implementation(libs.kotlinx.serialization.json)
            }
        }
    }
}