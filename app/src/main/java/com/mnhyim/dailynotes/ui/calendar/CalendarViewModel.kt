package com.mnhyim.dailynotes.ui.calendar

import androidx.lifecycle.*
import com.mnhyim.core.domain.model.Note
import com.mnhyim.core.domain.usecase.NoteUseCase

class CalendarViewModel(private val useCase: NoteUseCase): ViewModel() {

    val mutableDates: MutableLiveData<Long> = MutableLiveData()
    val notes: LiveData<List<Note>> = Transformations.switchMap(mutableDates) { param ->
        useCase.getDaysNotes(param).asLiveData()
    }

    fun searchByDates(param: Long) {
        mutableDates.value = param
    }

}