package io.github.regbl.migrainetracker.data

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithQuestionnaires(
    @Embedded val user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val questionnaires: List<Questionnaire>
)
