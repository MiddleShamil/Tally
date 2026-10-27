package conventionplugins.project

import extensions.commonMainDependencies
import extensions.commonTestDependencies
import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class KmpKoinPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            val koinBom = dependencies.platform(libs.koin.bom)

            commonMainDependencies {
                implementation(koinBom)
                implementation(libs.koin.core)
            }

            commonTestDependencies {
                implementation(koinBom)
                implementation(libs.koin.test)
            }

            // Koin для Compose нужен только UI-модулям
            pluginManager.withPlugin("org.jetbrains.compose") {
                commonMainDependencies {
                    implementation(libs.koin.compose)
                    implementation(libs.koin.compose.viewmodel)
                    implementation(libs.koin.compose.viewmodel.navigation)
                }
            }
        }
    }
}