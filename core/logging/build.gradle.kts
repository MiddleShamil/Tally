import extensions.commonMainDependencies

plugins {
    id("kmp.library.plugin")
    id("kmp.koin.plugin")
}

commonMainDependencies {
    api(libs.kermit)
}