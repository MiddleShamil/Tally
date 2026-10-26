import extensions.commonMainDependencies

plugins {
    id("feature.impl.plugin")
}

commonMainDependencies {
    implementation(project(":feature:scanner:api"))
}