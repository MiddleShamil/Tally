package ru.abdullaev.tally.core.database.di

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.abdullaev.tally.core.database.AppDatabase

internal const val DATABASE_NAME = "tally.db"

expect val platformDatabaseModule: Module

val databaseModule =
    module {
        includes(platformDatabaseModule)

        single<AppDatabase> {
            get<RoomDatabase.Builder<AppDatabase>>()
                .setDriver(BundledSQLiteDriver())
                .setQueryCoroutineContext(Dispatchers.Default)
                .build()
        }
        single { get<AppDatabase>().userDao() }
    }
