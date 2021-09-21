package io.github.regbl.migrainetracker.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    var userName: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
