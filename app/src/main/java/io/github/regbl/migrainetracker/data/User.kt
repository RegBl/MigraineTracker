package io.github.regbl.migrainetracker.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    val userName: String
) {
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
}
