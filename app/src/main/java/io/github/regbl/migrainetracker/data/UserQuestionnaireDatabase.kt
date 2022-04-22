package io.github.regbl.migrainetracker.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.regbl.migrainetracker.data.model.Questionnaire
import java.time.LocalDateTime

@Database(
    entities = [Questionnaire::class],
    version = 2,
    exportSchema = false
)
abstract class UserQuestionnaireDatabase : RoomDatabase() {
    abstract fun questionnaireDao(): QuestionnaireDao

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun populateDatabase(questionnaireDao: QuestionnaireDao) {
        questionnaireDao.deleteAll()

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
            userId = 1
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
            userId = 1
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
            userId = 1
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
            userId = 1
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
            userId = 1
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
            userId = 1
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
            userId = 1
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
            userId = 1
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
            userId = 1
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
            userId = 1
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
            userId = 1
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
            userId = 1
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
            userId = 1
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
            userId = 1
        )
        questionnaireDao.insertQuestionnaire(questionnaire)
    }
}