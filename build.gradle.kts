import io.gitlab.arturbosch.detekt.Detekt

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidMultiplatformLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.detekt)
}

detekt {
    source.setFrom(
        fileTree(rootDir) {
            include("**/src/**/*.kt")
            exclude("**/build/**")
        }
    )
    config.setFrom("config/detekt/detekt.yml")
    buildUponDefaultConfig = true
    parallel = true
}

tasks.withType<Detekt>().configureEach {
    reports {
        html.required.set(true)
        sarif.required.set(true)
    }
}

dependencies {
    detektPlugins(libs.detekt.formatting)
    detektPlugins(libs.detekt.composeRules)
}