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
        namespace = "ru.abdullaev.tally.shared"

        androidResources {
            enable = true
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}