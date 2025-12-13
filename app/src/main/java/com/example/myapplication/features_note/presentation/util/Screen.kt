package com.example.myapplication.features_note.presentation.util

sealed class Screen(val route: String) {
    object NotesScreen: Screen("notesView_screen")
    object AddEditNoteScreen: Screen("create_modify_note_screen")
}