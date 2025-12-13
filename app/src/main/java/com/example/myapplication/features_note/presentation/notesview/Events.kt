package com.example.myapplication.features_note.presentation.notesview

import com.example.myapplication.features_note.domain.model.Note
import com.example.myapplication.features_note.domain.util.NoteOrder

sealed class Events {
    data class Order(val noteOrder: NoteOrder): Events()
    data class DeleteNote(val note: Note): Events()
    object ToggleOrderSection: Events()
}