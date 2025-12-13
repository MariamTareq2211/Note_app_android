package com.example.myapplication.features_note.domain.use_case

data class NoteUseCases(
    val getNotes : getNotes,
    val deleteNote: deleteNote,
    val addNote: addNote,
    val getNote: getNote
)
