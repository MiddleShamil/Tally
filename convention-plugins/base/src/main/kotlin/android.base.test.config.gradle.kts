import extensions.libs

plugins {
    id("kmp.base.config")
}

kotlin {
    android {
        withHostTest {
            isIncludeAndroidResources = true
        }
        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    sourceSets {
        getByName("androidDeviceTest").dependencies {
            implementation(libs.androidx.testExt.junit)
            implementation(libs.androidx.test.runner)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}