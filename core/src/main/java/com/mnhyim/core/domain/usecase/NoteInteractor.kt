package com.mnhyim.core.domain.usecase

import com.mnhyim.core.domain.model.Note
import com.mnhyim.core.domain.repository.NoteRepositoryInterface
import com.mnhyim.core.utils.Executors
import kotlinx.coroutines.flow.Flow

class NoteInteractor(
    private val noteRepository: NoteRepositoryInterface) : NoteUseCase {

    override suspend fun insertNote(note: Note) {
        return noteRepository.insertNote(note)
    }

    override fun deleteNote(note: Note) {
        return noteRepository.deleteNote(note)
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return noteRepository.getAllNotes()
    }

    override fun getDaysNotes(date: String): Flow<List<Note>> {
        return noteRepository.getDaysNotes(date)
    }

    override fun countTotalNotes(): Flow<Int> {
        return noteRepository.countTotalNotes()
    }

    override fun countFutureNotes(inputDate: Long): Flow<Int> {
        return noteRepository.countFutureNotes(inputDate)
    }
}