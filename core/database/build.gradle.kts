import extensions.commonMainDependencies
import extensions.commonTestDependencies

plugins {
    id("kmp.library.plugin")
    id("kmp.coroutines.plugin")
    id("kmp.room.plugin")
    id("kmp.koin.plugin")
}

commonMainDependencies {
    implementation(libs.kotlinx.datetime)
    implementation(project(":core:logging"))
}

commonTestDependencies {
    implementation(libs.room.testing)
}