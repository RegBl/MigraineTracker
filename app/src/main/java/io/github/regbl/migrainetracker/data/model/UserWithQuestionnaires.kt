package io.github.regbl.migrainetracker.data.model

import androidx.room.Embedded
import androidx.room.Relation
import io.github.regbl.migrainetracker.data.model.Questionnaire
import io.github.regbl.migrainetracker.data.model.User

data class UserWithQuestionnaires(
    @Embedded val user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val questionnaires: List<Questionnaire>
)
