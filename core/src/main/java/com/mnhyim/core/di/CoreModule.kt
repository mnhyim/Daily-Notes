package com.mnhyim.core.di

import androidx.room.Room
import com.mnhyim.core.data.room.NoteRoomDatabase
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