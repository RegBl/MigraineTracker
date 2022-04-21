package io.github.regbl.migrainetracker

import android.app.Application
import io.github.regbl.migrainetracker.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MigraineTrackerApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MigraineTrackerApplication)
            modules(
                AppModule().userQuestionnaireRepositoryModule,
                AppModule().dailyRecordViewModelModule,
                AppModule().mainFragmentViewModelModule,
                AppModule().databaseModule
            )
        }
    }
}