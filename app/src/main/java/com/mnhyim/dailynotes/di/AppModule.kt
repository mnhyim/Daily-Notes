package com.mnhyim.dailynotes.di

import com.mnhyim.core.domain.usecase.NoteInteractor
import com.mnhyim.core.domain.usecase.NoteUseCase
import com.mnhyim.dailynotes.ui.calendar.CalendarViewModel
import com.mnhyim.dailynotes.ui.home.HomeViewModel
import com.mnhyim.dailynotes.ui.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<NoteUseCase> { NoteInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { ListViewModel(get()) }
    viewModel { CalendarViewModel(get()) }
}