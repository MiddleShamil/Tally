import extensions.androidMainDependencies
import extensions.commonMainDependencies
import extensions.libs

plugins {
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.compose")

    id("kmp.base.config")
}

commonMainDependencies {
    implementation(libs.compose.runtime)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material3)
    implementation(libs.compose.ui)
    implementation(libs.compose.components.resources)
    implementation(libs.compose.uiToolingPreview)
}

androidMainDependencies {
    implementation(libs.compose.uiTooling)
}