package com.example.myapplication.features_note.domain.use_case

import com.example.myapplication.features_note.domain.model.Note
import com.example.myapplication.features_note.domain.repository.NoteRepo

class getNote (
    private val repository: NoteRepo
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}