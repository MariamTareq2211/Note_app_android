package com.example.myapplication.features_note.data.repository

import com.example.myapplication.features_note.data.data_source.NoteDao
import com.example.myapplication.features_note.domain.model.Note
import com.example.myapplication.features_note.domain.repository.NoteRepo
import kotlinx.coroutines.flow.Flow

class NoteRepoImpl(
    private val dao : NoteDao
) : NoteRepo {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }


}