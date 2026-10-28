package ru.abdullaev.tally

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import ru.abdullaev.tally.di.initKoin

class TallyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@TallyApplication)
            androidLogger()
        }
    }
}