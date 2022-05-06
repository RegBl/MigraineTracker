package io.github.regbl.migrainetracker.di

import androidx.room.Room
import io.github.regbl.migrainetracker.data.UserQuestionnaireDatabase
import io.github.regbl.migrainetracker.repository.UserQuestionnaireRepository
import io.github.regbl.migrainetracker.viewmodel.DailyRecordViewModel
import io.github.regbl.migrainetracker.viewmodel.MainFragmentViewModel
import io.github.regbl.migrainetracker.viewmodel.PastRecordsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class AppModule {
    val userQuestionnaireRepositoryModule = module {
        single { UserQuestionnaireRepository(get()) }
    }

    val dailyRecordViewModelModule = module {
        viewModel { DailyRecordViewModel(get()) }
    }

    val pastRecordsViewModelModule = module {
        viewModel { PastRecordsViewModel(get()) }
    }

    val mainFragmentViewModelModule = module {
        viewModel { MainFragmentViewModel() }
    }

    val databaseModule = module {
        single {
            Room.databaseBuilder(
                this.androidApplication(),
                UserQuestionnaireDatabase::class.java,
                "user_questionnaire_db"
            )
                .fallbackToDestructiveMigration()
                .build()
        }

        single { get<UserQuestionnaireDatabase>().questionnaireDao() }
    }
}