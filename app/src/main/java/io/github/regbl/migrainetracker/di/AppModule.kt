package io.github.regbl.migrainetracker.di

import io.github.regbl.migrainetracker.data.UserQuestionnaireRepository
import io.github.regbl.migrainetracker.viewmodels.DailyRecordViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class AppModule {
    val appModule : Module = module {
        single { UserQuestionnaireRepository(get()) }

        viewModel { DailyRecordViewModel(get()) }
    }
}