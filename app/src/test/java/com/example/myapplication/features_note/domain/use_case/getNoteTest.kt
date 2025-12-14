package com.example.myapplication.features_note.domain.use_case

import com.example.myapplication.features_note.domain.model.Note
import com.example.myapplication.features_note.domain.repository.NoteRepo
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
class getNoteTest {
    @Mock
    lateinit var repository: NoteRepo

    @InjectMocks
    lateinit var getNote: getNote

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun getNote_returnsCorrectNote() = runBlocking {
        val note = Note(
            title = "Test",
            content = "Content",
            timestamp = 1L,
            color = 0,
            id = 1
        )

        Mockito.`when`(repository.getNoteById(1)).thenReturn(note)

        val result = getNote(1)

        assertEquals(note, result)
    }

}