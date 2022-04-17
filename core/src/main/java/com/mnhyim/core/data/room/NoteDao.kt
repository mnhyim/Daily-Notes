package com.mnhyim.core.data.room

import androidx.room.*
import com.mnhyim.core.data.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: NoteEntity)

    @Delete
    fun delete(note: NoteEntity)

    @Update
    fun update(note: NoteEntity)

    @Query("SELECT * FROM notes ORDER BY date")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE date = :date")
    fun getDaysNotes(date: Long): Flow<List<NoteEntity>>

    @Query("SELECT COUNT(*) FROM notes")
    fun countTotalNotes(): Flow<Int>

    @Query("SELECT COUNT(*) FROM notes WHERE date > :inputDate")
    fun countFutureNotes(inputDate: Long): Flow<Int>
}