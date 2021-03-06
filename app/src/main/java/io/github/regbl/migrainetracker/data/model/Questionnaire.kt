package io.github.regbl.migrainetracker.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "questionnaire_table"
)
data class Questionnaire(
    @PrimaryKey(autoGenerate = true)
    var questionnaireId: Int,

    // userId - foreign key artefact of previous design
    var userId: Int,

    // "I had headaches lasting how long?"
    var questionOne: String?,

    // "Intensity (1-10)"
    var questionTwo: String?,

    // "Missed work (Y/N)"
    var questionThree: String?,

    // "Aura (describe)"
    var questionFour: String?,

    // "Nausea (Y/N)"
    var questionFive: String?,

    // "Light Sensitive (Y/N)"
    var questionSix: String?,

    // "Sound Sensitive (Y/N)"
    var questionSeven: String?,

    // "Medications (Y/N)"
    var questionEight: String?,

    // "Good Response (Y/N)"
    var questionNine: String?,

    var dateTime: String
)