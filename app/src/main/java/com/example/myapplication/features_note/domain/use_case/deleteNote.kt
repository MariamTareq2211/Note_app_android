package com.example.myapplication.features_note.domain.use_case

import com.example.myapplication.features_note.domain.model.Note
import com.example.myapplication.features_note.domain.repository.NoteRepo

class deleteNote( private val repo: NoteRepo ) {

    suspend operator fun invoke(note: Note) {
        repo.deleteNote(note)
    }
}