package io.github.regbl.migrainetracker.data

import androidx.room.*
import java.time.LocalDateTime
import java.util.*

@Entity(
    tableName = "questionnaire_table",
    foreignKeys = [ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["userId"])]
)
data class Questionnaire(
    val userId: Long,

    // "I had headaches lasting how long?"
    val questionOne: String?,

    // "Intensity (1-10)"
    val questionTwo: String?,

    // "Missed work (Y/N)"
    val questionThree: String?,

    // "Aura (describe)"
    val questionFour: String?,

    // "Nausea (Y/N)"
    val questionFive: String?,

    // "Light Sensitive (Y/N)"
    val questionSix: String?,

    // "Sound Sensitive (Y/N)"
    val questionSeven: String?,

    // "Medications (Y/N)"
    val questionEight: String?,

    // "Good Response (Y/N)"
    val questionNine: String?,
    val dateTime: LocalDateTime
) {
    @PrimaryKey(autoGenerate = true)
    val questionnaireId: Long = 0
}