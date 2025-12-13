package com.example.myapplication.features_note.presentation.notesview

import com.example.myapplication.features_note.domain.model.Note
import com.example.myapplication.features_note.domain.util.NoteOrder
import com.example.myapplication.features_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
