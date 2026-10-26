package conventionplugins.project

import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryTarget
import extensions.kotlinMultiplatformConfig
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.configure

class KmpLibraryPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("kmp.base.config")
                apply("android.base.test.config")
            }

            kotlinMultiplatformConfig {
                (this as ExtensionAware).extensions.configure<KotlinMultiplatformAndroidLibraryTarget> {
                    // :feature:diary:impl -> ru.abdullaev.tally.feature.diary.impl
                    namespace = "ru.abdullaev.tally" + path.replace(':', '.')
                }
            }
        }
    }
}
