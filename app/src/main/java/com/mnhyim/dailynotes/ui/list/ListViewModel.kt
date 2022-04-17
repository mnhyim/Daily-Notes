package com.mnhyim.dailynotes.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mnhyim.core.domain.usecase.NoteUseCase

class ListViewModel(private val useCase: NoteUseCase): ViewModel() {

    val notes = useCase.getAllNotes().asLiveData()
}