@file:OptIn(ExperimentalForeignApi::class)

package ru.abdullaev.tally.core.database.di

import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask
import ru.abdullaev.tally.core.database.AppDatabase

actual val platformDatabaseModule: Module =
    module {
        single<RoomDatabase.Builder<AppDatabase>> {
            Room.databaseBuilder<AppDatabase>(name = "${documentDirectory()}/$DATABASE_NAME")
        }
    }

private fun documentDirectory(): String {
    val url =
        NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null,
        )
    return requireNotNull(url?.path)
}