import extensions.commonMainDependencies
import extensions.iosRegularFramework

plugins {
    id("kmp.compose.library.plugin")
    id("kmp.koin.plugin")
}

kotlin {
    iosRegularFramework {
        baseName = "Shared"
        isStatic = true
    }

    android {
        androidResources {
            enable = true
        }
    }
}

commonMainDependencies {
    implementation(libs.androidx.navigation.compose)

    implementation(project(":core:data"))

    implementation(project(":feature:diary:impl"))
    implementation(project(":feature:products:impl"))
    implementation(project(":feature:scanner:impl"))
    implementation(project(":feature:profile:impl"))
}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}