package com.mnhyim.dailynotes.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mnhyim.core.domain.model.Note
import com.mnhyim.core.domain.usecase.NoteUseCase
import java.text.SimpleDateFormat
import java.util.*

class HomeViewModel(private val useCase: NoteUseCase): ViewModel() {

    private val TAG: String = HomeViewModel::class.java.simpleName.toString()

    val totalNotes = useCase.countTotalNotes().asLiveData()
    private val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    val upcomingNotes = useCase.countFutureNotes((sdf.parse(sdf.format(Calendar.getInstance().time)) as Date).time).asLiveData()

    suspend fun insertNote(note: Note) {
        Log.d("INSERT NEW NOTE", TAG)
        return useCase.insertNote(note)
    }


}