package io.github.regbl.migrainetracker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [Questionnaire::class, User::class],
    version = 1,
    exportSchema = false
)
abstract class UserQuestionnaireDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun questionnaireDao(): QuestionnaireDao

    companion object {
        @Volatile private var INSTANCE: UserQuestionnaireDatabase? = null

        fun getInstance(
            context: Context,
            scope: CoroutineScope
        ): UserQuestionnaireDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserQuestionnaireDatabase::class.java,
                    "user_questionnaire_db"
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class UserQuestionnaireDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                    }
                }
            }

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
            }
        }

        suspend fun populateDatabase(questionnaireDao: QuestionnaireDao) {
            questionnaireDao.deleteAll()


        }
    }
}