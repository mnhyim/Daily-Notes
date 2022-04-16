package com.mnhyim.core.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mnhyim.core.data.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteRoomDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDao
}