package com.example.myapplication.features_note.domain.use_case

import org.junit.Assert.*
import com.example.myapplication.features_note.domain.model.InvalidNoteException
import com.example.myapplication.features_note.domain.model.Note
import com.example.myapplication.features_note.domain.repository.NoteRepo
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class addNoteTest {

    @Mock
    lateinit var repository: NoteRepo

    private lateinit var addNote: addNote

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        addNote = addNote(repository)
    }

    @Test
    fun addNote_withValidData_callsInsertNote() = runBlocking {
        val note = Note(
            title = "Test",
            content = "Content",
            timestamp = 1L,
            color = 0
        )

        addNote(note)

        verify(repository).insertNote(note)
    }

    @Test
    fun addNote_withEmptyTitle_throwsException() = runBlocking {
        val note = Note(
            title = "",
            content = "Content",
            timestamp = 1L,
            color = 0
        )

        try {
            addNote(note)
            fail("Expected InvalidNoteException")
        } catch (e: InvalidNoteException) {
            // success
        }
    }
}
