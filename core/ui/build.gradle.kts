import extensions.commonMainDependencies

plugins {
    id("kmp.compose.library.plugin")
    id("kmp.coroutines.plugin")
}

commonMainDependencies {
    implementation(project(":core:logging"))
}