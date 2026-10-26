package conventionplugins.project

import extensions.androidMainDependencies
import extensions.commonMainDependencies
import extensions.commonTestDependencies
import extensions.iosMainDependencies
import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class KmpKtorPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("kmp.serialization.plugin")

            commonMainDependencies {
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.contentNegotiation)
                implementation(libs.ktor.client.logging)
                implementation(libs.ktor.serialization.kotlinxJson)
            }

            androidMainDependencies {
                implementation(libs.ktor.client.okhttp)
            }

            iosMainDependencies {
                implementation(libs.ktor.client.darwin)
            }

            commonTestDependencies {
                implementation(libs.ktor.client.mock)
            }
        }
    }
}
