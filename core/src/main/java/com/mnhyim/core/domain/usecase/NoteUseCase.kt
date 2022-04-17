package com.mnhyim.core.domain.usecase

import com.mnhyim.core.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteUseCase {

    suspend fun insertNote(note: Note)
    fun deleteNote(note: Note)
    fun getAllNotes(): Flow<List<Note>>
    fun getDaysNotes(date: String): Flow<List<Note>>
}