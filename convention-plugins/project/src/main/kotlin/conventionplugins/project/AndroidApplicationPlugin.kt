package conventionplugins.project

import com.android.build.api.dsl.ApplicationExtension
import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugins.androidApplication.get().pluginId)
                apply(libs.plugins.composeCompiler.get().pluginId)
                apply("android.base.config")
            }

            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    targetSdk = libs.versions.targetSdk.get().toInt()

                    versionCode = libs.versions.versionCode.get().toInt()
                    versionName = libs.versions.versionName.get()
                }
                buildFeatures {
                    compose = true
                }
            }
        }
    }
}
