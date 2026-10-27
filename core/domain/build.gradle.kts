import extensions.commonMainDependencies

plugins {
    id("kmp.library.plugin")
    id("kmp.coroutines.plugin")
}

commonMainDependencies {
    api(libs.kotlinx.datetime)
}