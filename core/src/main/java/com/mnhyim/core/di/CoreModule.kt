package com.mnhyim.core.di

import androidx.room.Room
import com.mnhyim.core.data.NoteDataSource
import com.mnhyim.core.data.NoteRepository
import com.mnhyim.core.data.room.NoteRoomDatabase
import com.mnhyim.core.domain.repository.NoteRepositoryInterface
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    factory { get<NoteRoomDatabase>().noteDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            NoteRoomDatabase::class.java, "notes.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val repositoryModule = module {
    single { NoteDataSource(get()) }
    single { NoteRepository(get()) }
    single<NoteRepositoryInterface> { NoteRepository(get()) }
}