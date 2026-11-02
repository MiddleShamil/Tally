package ru.abdullaev.tally.core.database.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.abdullaev.tally.core.database.AppDatabase

actual val platformDatabaseModule: Module =
    module {
        single<RoomDatabase.Builder<AppDatabase>> {
            val context = get<Context>()
            Room.databaseBuilder<AppDatabase>(
                context = context,
                name = context.getDatabasePath(DATABASE_NAME).absolutePath,
            )
        }
    }