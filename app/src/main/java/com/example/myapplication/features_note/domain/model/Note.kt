package com.example.myapplication.features_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.ui.theme.*

@Entity
data class Note(
val title: String,
val content: String,
val timestamp: Long,
val color: Int,
@PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(Green1,Green2,Green3,Green4)
    }
}

class InvalidNoteException(message: String): Exception(message)
