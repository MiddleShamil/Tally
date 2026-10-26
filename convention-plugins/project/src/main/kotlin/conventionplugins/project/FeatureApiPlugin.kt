package conventionplugins.project

import org.gradle.api.Plugin
import org.gradle.api.Project

class FeatureApiPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("kmp.library.plugin")
                apply("kmp.serialization.plugin")
            }
        }
    }
}