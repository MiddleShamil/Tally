package ru.abdullaev.tally.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes
import org.koin.dsl.module
import ru.abdullaev.tally.core.database.di.databaseModule

val appModule =
    module {
        includes(databaseModule)
    }

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        includes(config)
        modules(appModule)
    }
}