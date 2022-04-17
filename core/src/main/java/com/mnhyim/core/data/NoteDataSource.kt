package com.mnhyim.core.data

import androidx.room.Query
import com.mnhyim.core.data.entity.NoteEntity
import com.mnhyim.core.data.room.NoteDao
import kotlinx.coroutines.flow.Flow

class NoteDataSource(private val dao: NoteDao) {

    suspend fun insert(note: NoteEntity) {
        dao.insert(note)
    }

    fun delete(note: NoteEntity) {
        dao.delete(note)
    }

    fun update(note: NoteEntity) {
        dao.update(note)
    }

    fun getAllNotes(): Flow<List<NoteEntity>> {
        return dao.getAllNotes()
    }

    fun getDaysNotes(date: String): Flow<List<NoteEntity>> {
        return dao.getDaysNotes(date)
    }

    fun countTotalNotes(): Flow<Int> {
        return dao.countTotalNotes()
    }

    fun countFutureNotes(inputDate: Long): Flow<Int> {
        return dao.countFutureNotes(inputDate)
    }
}