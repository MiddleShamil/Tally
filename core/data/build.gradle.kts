import extensions.commonMainDependencies

plugins {
    id("kmp.library.plugin")
    id("kmp.coroutines.plugin")
    id("kmp.koin.plugin")
}

commonMainDependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:database"))
    implementation(project(":core:network"))
    implementation(project(":core:logging"))
}