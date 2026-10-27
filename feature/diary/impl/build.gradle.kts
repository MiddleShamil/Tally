import extensions.commonMainDependencies

plugins {
    id("feature.impl.plugin")
}

commonMainDependencies {
    // Добавление еды из дневника
    implementation(project(":feature:products:api"))
}