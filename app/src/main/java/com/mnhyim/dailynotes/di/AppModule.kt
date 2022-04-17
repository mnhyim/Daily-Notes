package com.mnhyim.dailynotes.di

import com.mnhyim.core.domain.usecase.NoteInteractor
import com.mnhyim.core.domain.usecase.NoteUseCase
import com.mnhyim.dailynotes.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<NoteUseCase> { NoteInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}