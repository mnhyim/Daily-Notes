package com.mnhyim.core.data

import com.mnhyim.core.domain.model.Note
import com.mnhyim.core.domain.repository.NoteRepositoryInterface
import com.mnhyim.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepository(private val dataSource: NoteDataSource) : NoteRepositoryInterface {

    override suspend fun insertNote(note: Note) {
        dataSource.insert(DataMapper.mapDomainToEntity(note))
    }

    override fun deleteNote(note: Note) {
        dataSource.delete(DataMapper.mapDomainToEntity(note))
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return dataSource.getAllNotes().map { DataMapper.mapEntityToDomain(it) }
    }

    override fun getDaysNotes(date: String): Flow<List<Note>> {
        return dataSource.getDaysNotes(date).map { DataMapper.mapEntityToDomain(it) }
    }
}