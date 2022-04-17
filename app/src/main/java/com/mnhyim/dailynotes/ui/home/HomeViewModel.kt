package com.mnhyim.dailynotes.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.mnhyim.core.domain.model.Note
import com.mnhyim.core.domain.usecase.NoteUseCase

class HomeViewModel(private val useCase: NoteUseCase): ViewModel() {

    private val TAG: String = HomeViewModel::class.java.simpleName.toString()

    suspend fun insertNote(note: Note) {
        Log.d("INSERT NEW NOTE", TAG)
        return useCase.insertNote(note)
    }
}