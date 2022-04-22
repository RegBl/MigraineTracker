package io.github.regbl.migrainetracker.utility

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun getDateTimeString(date: OffsetDateTime): String {
    val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    return date.format(formatter)
}

@RequiresApi(Build.VERSION_CODES.O)
fun getDateTimeNowString() = getDateTimeString(OffsetDateTime.now())
