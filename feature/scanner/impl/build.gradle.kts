import extensions.androidMainDependencies

plugins {
    id("feature.impl.plugin")
}

androidMainDependencies {
    implementation(libs.androidx.camera.core)
    implementation(libs.androidx.camera.camera2)
    implementation(libs.androidx.camera.lifecycle)
    implementation(libs.androidx.camera.view)
    implementation(libs.mlkit.barcodeScanning)
}
