import extensions.commonMainDependencies
import extensions.iosRegularFramework

plugins {
    id("android.base.test.config")
    id("kmp.compose.config")
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

commonMainDependencies {
    implementation(libs.androidx.lifecycle.viewmodelCompose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}