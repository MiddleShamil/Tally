package conventionplugins.project

import extensions.commonMainDependencies
import extensions.commonTestDependencies
import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class KmpCoroutinesPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            commonMainDependencies {
                implementation(libs.kotlinx.coroutines.core)
            }

            commonTestDependencies {
                implementation(libs.kotlinx.coroutines.test)
                implementation(libs.turbine)
            }
        }
    }
}
