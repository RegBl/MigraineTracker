package io.github.regbl.migrainetracker.data

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.util.*

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
                    .addCallback(UserQuestionnaireDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class UserQuestionnaireDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            // TODO: Handle older java SDK versions
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.questionnaireDao(), database.userDao())
                    }
                }
            }

            // TODO: Handle older java SDK versions
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.questionnaireDao(), database.userDao())
                    }
                }
            }
        }

        // TODO: Handle older java SDK versions
        @RequiresApi(Build.VERSION_CODES.O)
        suspend fun populateDatabase(questionnaireDao: QuestionnaireDao, userDao: UserDao) {
            questionnaireDao.deleteAll()

            var user = User("Jane Doe")
            userDao.insertUser(user)

            var questionnaire = Questionnaire(
                questionOne = "Six Hours",
                questionTwo = "8",
                questionThree = "Y",
                questionFour = "Sensitive to smells",
                questionFive = "N",
                questionSix = "Y",
                questionSeven = "Y",
                questionEight = "N",
                questionNine = "",
                dateTime = LocalDateTime.of(2021, 8, 10, 14, 32).toString(),
                userId = user.id
            )
            questionnaireDao.insertQuestionnaire(questionnaire)

            questionnaire = Questionnaire(
                questionOne = "Six Hours",
                questionTwo = "7",
                questionThree = "Y",
                questionFour = "Sound causes pain",
                questionFive = "N",
                questionSix = "Y",
                questionSeven = "Y",
                questionEight = "N",
                questionNine = "",
                dateTime = LocalDateTime.of(2021, 8, 11, 14, 32).toString(),
                userId = user.id
            )
            questionnaireDao.insertQuestionnaire(questionnaire)

            questionnaire = Questionnaire(
                questionOne = "Six Hours",
                questionTwo = "9",
                questionThree = "Y",
                questionFour = "Can't stand light",
                questionFive = "N",
                questionSix = "Y",
                questionSeven = "Y",
                questionEight = "N",
                questionNine = "",
                dateTime = LocalDateTime.of(2021, 8, 12, 14, 32).toString(),
                userId = user.id
            )
            questionnaireDao.insertQuestionnaire(questionnaire)

            questionnaire = Questionnaire(
                questionOne = "Six Hours",
                questionTwo = "6",
                questionThree = "Y",
                questionFour = "Sensitive to smells",
                questionFive = "N",
                questionSix = "Y",
                questionSeven = "Y",
                questionEight = "N",
                questionNine = "",
                dateTime = LocalDateTime.of(2021, 8, 13, 14, 32).toString(),
                userId = user.id
            )
            questionnaireDao.insertQuestionnaire(questionnaire)

            questionnaire = Questionnaire(
                questionOne = "Six Hours",
                questionTwo = "9",
                questionThree = "Y",
                questionFour = "Sound causes pain",
                questionFive = "N",
                questionSix = "Y",
                questionSeven = "Y",
                questionEight = "N",
                questionNine = "",
                dateTime = LocalDateTime.of(2021, 8, 14, 14, 32).toString(),
                userId = user.id
            )
            questionnaireDao.insertQuestionnaire(questionnaire)

            questionnaire = Questionnaire(
                questionOne = "Six Hours",
                questionTwo = "8",
                questionThree = "Y",
                questionFour = "Can't stand light",
                questionFive = "N",
                questionSix = "Y",
                questionSeven = "Y",
                questionEight = "N",
                questionNine = "",
                dateTime = LocalDateTime.of(2021, 8, 15, 14, 32).toString(),
                userId = user.id
            )
            questionnaireDao.insertQuestionnaire(questionnaire)

            questionnaire = Questionnaire(
                questionOne = "Six Hours",
                questionTwo = "7",
                questionThree = "Y",
                questionFour = "Sensitive to smells",
                questionFive = "N",
                questionSix = "Y",
                questionSeven = "Y",
                questionEight = "N",
                questionNine = "",
                dateTime = LocalDateTime.of(2021, 8, 16, 14, 32).toString(),
                userId = user.id
            )
            questionnaireDao.insertQuestionnaire(questionnaire)

            questionnaire = Questionnaire(
                questionOne = "Six Hours",
                questionTwo = "7",
                questionThree = "Y",
                questionFour = "Sound causes pain",
                questionFive = "N",
                questionSix = "Y",
                questionSeven = "Y",
                questionEight = "N",
                questionNine = "",
                dateTime = LocalDateTime.of(2021, 8, 17, 14, 32).toString(),
                userId = user.id
            )
            questionnaireDao.insertQuestionnaire(questionnaire)

            questionnaire = Questionnaire(
                questionOne = "Six Hours",
                questionTwo = "7",
                questionThree = "Y",
                questionFour = "Can't stand light",
                questionFive = "N",
                questionSix = "Y",
                questionSeven = "Y",
                questionEight = "N",
                questionNine = "",
                dateTime = LocalDateTime.of(2021, 8, 18, 14, 32).toString(),
                userId = user.id
            )
            questionnaireDao.insertQuestionnaire(questionnaire)

            questionnaire = Questionnaire(
                questionOne = "Six Hours",
                questionTwo = "9",
                questionThree = "Y",
                questionFour = "Can't stand light",
                questionFive = "N",
                questionSix = "Y",
                questionSeven = "Y",
                questionEight = "N",
                questionNine = "",
                dateTime = LocalDateTime.of(2021, 8, 19, 14, 32).toString(),
                userId = user.id
            )
            questionnaireDao.insertQuestionnaire(questionnaire)

            questionnaire = Questionnaire(
                questionOne = "Six Hours",
                questionTwo = "6",
                questionThree = "Y",
                questionFour = "Sound causes pain",
                questionFive = "N",
                questionSix = "Y",
                questionSeven = "Y",
                questionEight = "N",
                questionNine = "",
                dateTime = LocalDateTime.of(2021, 8, 20, 14, 32).toString(),
                userId = user.id
            )
            questionnaireDao.insertQuestionnaire(questionnaire)

            questionnaire = Questionnaire(
                questionOne = "Six Hours",
                questionTwo = "5",
                questionThree = "Y",
                questionFour = "Sensitive to smells",
                questionFive = "N",
                questionSix = "Y",
                questionSeven = "Y",
                questionEight = "N",
                questionNine = "",
                dateTime = LocalDateTime.of(2021, 8, 21, 14, 32).toString(),
                userId = user.id
            )
            questionnaireDao.insertQuestionnaire(questionnaire)

            questionnaire = Questionnaire(
                questionOne = "Six Hours",
                questionTwo = "8",
                questionThree = "Y",
                questionFour = "Can't stand light",
                questionFive = "N",
                questionSix = "Y",
                questionSeven = "Y",
                questionEight = "N",
                questionNine = "",
                dateTime = LocalDateTime.of(2021, 8, 22, 14, 32).toString(),
                userId = user.id
            )
            questionnaireDao.insertQuestionnaire(questionnaire)

            questionnaire = Questionnaire(
                questionOne = "Six Hours",
                questionTwo = "7",
                questionThree = "Y",
                questionFour = "Sound causes pain",
                questionFive = "N",
                questionSix = "Y",
                questionSeven = "Y",
                questionEight = "N",
                questionNine = "",
                dateTime = LocalDateTime.of(2021, 8, 23, 14, 32).toString(),
                userId = user.id
            )
            questionnaireDao.insertQuestionnaire(questionnaire)
        }
    }
}