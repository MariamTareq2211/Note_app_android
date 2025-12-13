package com.example.myapplication.features_note.domain.use_case

import com.example.myapplication.features_note.domain.model.InvalidNoteException
import com.example.myapplication.features_note.domain.model.Note
import com.example.myapplication.features_note.domain.repository.NoteRepo

class addNote (
    private val repository: NoteRepo
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if(note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty!")
        }
        if(note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty!")
        }
        repository.insertNote(note)
    }
}