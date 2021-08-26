package io.github.regbl.migrainetracker.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questionnaire_table")
data class Questionnaire(
    @PrimaryKey(autoGenerate = true)
    val questionnaireId: Int,
    val userId: Int,
    val questionOne: String?,
    val questionTwo: String?,
    val questionThree: String?,
    val questionFour: String?,
    val questionFive: String?,
    val questionSix: String?,
    val questionSeven: String?,
    val questionEight: String?,
    val questionNine: String?,
    val dateTime: String
)
