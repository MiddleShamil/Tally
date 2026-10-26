package conventionplugins.project

import androidx.room.gradle.RoomExtension
import extensions.commonMainDependencies
import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class KmpRoomPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugins.ksp.get().pluginId)
                apply(libs.plugins.room.get().pluginId)
            }

            extensions.configure<RoomExtension> {
                schemaDirectory("$projectDir/schemas")
            }

            commonMainDependencies {
                implementation(libs.room.runtime)
                implementation(libs.sqlite.bundled)
            }

            dependencies {
                listOf("kspAndroid", "kspIosArm64", "kspIosSimulatorArm64").forEach { configuration ->
                    add(configuration, libs.room.compiler)
                }
            }
        }
    }
}