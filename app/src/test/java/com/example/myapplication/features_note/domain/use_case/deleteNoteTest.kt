package com.example.myapplication.features_note.domain.use_case

import com.example.myapplication.features_note.domain.model.Note
import com.example.myapplication.features_note.domain.repository.NoteRepo
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


@RunWith(JUnit4::class)
class deleteNoteTest {

    @Mock
    lateinit var repository: NoteRepo

    @InjectMocks
    lateinit var deleteNote: deleteNote

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun deleteNote_callsDeleteNoteOnRepository() = runBlocking {
        val note = Note(
            title = "Test",
            content = "Content",
            timestamp = 1L,
            color = 0,
            id = 1
        )

        deleteNote(note)

        Mockito.verify(repository).deleteNote(note)
    }

}