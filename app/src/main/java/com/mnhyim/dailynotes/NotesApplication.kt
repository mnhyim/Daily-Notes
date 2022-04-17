package com.mnhyim.dailynotes

import android.app.Application
import com.mnhyim.core.di.databaseModule
import com.mnhyim.core.di.repositoryModule
import com.mnhyim.dailynotes.di.useCaseModule
import com.mnhyim.dailynotes.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class NotesApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@NotesApplication)
            modules(
                listOf(
                    databaseModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}