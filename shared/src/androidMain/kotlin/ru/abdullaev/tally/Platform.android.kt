// Имя файла по KMP-конвенции expect/actual: Platform.<target>.kt
@file:Suppress("MatchingDeclarationName")

package ru.abdullaev.tally

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()