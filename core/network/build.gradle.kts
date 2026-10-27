import extensions.commonMainDependencies

plugins {
    id("kmp.library.plugin")
    id("kmp.coroutines.plugin")
    id("kmp.ktor.plugin")
    id("kmp.koin.plugin")
}

commonMainDependencies {
    implementation(project(":core:logging"))
}