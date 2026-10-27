// Имя файла по KMP-конвенции expect/actual: Platform.<target>.kt
@file:Suppress("MatchingDeclarationName")

package ru.abdullaev.tally

import platform.UIKit.UIDevice

class IOSPlatform : Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()