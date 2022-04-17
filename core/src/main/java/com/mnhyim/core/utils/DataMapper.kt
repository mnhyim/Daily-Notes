package com.mnhyim.core.utils

import com.mnhyim.core.data.entity.NoteEntity
import com.mnhyim.core.domain.model.Note

object DataMapper {

    fun mapDomainToEntity(note: Note): NoteEntity {
        return NoteEntity(
            id = note.id,
            title = note.title,
            content = note.content,
            date = note.date
        )
    }

    fun mapDomainToEntity(notes: List<Note>): List<NoteEntity> {
        return notes.map {
            NoteEntity(
                id = it.id,
                title = it.title,
                content = it.content,
                date = it.date
            )
        }
    }

    fun mapEntityToDomain(note: NoteEntity): Note {
        return Note(
            id = note.id,
            title = note.title,
            content = note.content,
            date = note.date
        )
    }

    fun mapEntityToDomain(notes: List<NoteEntity>): List<Note> {
        return notes.map {
            Note(
                id = it.id,
                title = it.title,
                content = it.content,
                date = it.date
            )
        }
    }
}