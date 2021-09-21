package io.github.regbl.migrainetracker.di

import androidx.room.Room
import io.github.regbl.migrainetracker.data.UserQuestionnaireDatabase
import io.github.regbl.migrainetracker.repository.UserQuestionnaireRepository
import io.github.regbl.migrainetracker.viewmodel.DailyRecordViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class AppModule {
    val userQuestionnaireRepositoryModule = module {
        single { UserQuestionnaireRepository(get()) }
    }

    val viewModelModule = module {
        viewModel { DailyRecordViewModel(get()) }
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
        single { get<UserQuestionnaireDatabase>().userDao() }
    }
}